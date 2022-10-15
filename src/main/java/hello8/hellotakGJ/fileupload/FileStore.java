package hello8.hellotakGJ.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String fileName){
        return fileDir + fileName;
    }

    //여러개 업로드
    public List<UpLoadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UpLoadFile> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }
    public UpLoadFile storeFile(MultipartFile multipartFile) throws IOException {
        //멀티파트 파일을 받아서 uploadfile로 변환해줌.
        if (multipartFile.isEmpty()) {
            return null;
        }
        String originalFileName = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFileName);
        //image.png 가 들어오면 서버에 저장하는 파일명을 UUID으로 만들어준다. 다만 확장자는 가져오고 싶다.

        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        return new UpLoadFile(originalFileName, storeFileName);
    }

    private String createStoreFileName(String originalFileName) {
        String ext = extractExt(originalFileName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFileName) {
        //확장자 추출을 위한 메소드
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }

}
