package hello8.hellotakGJ.fileupload;

import lombok.Data;

@Data
public class UpLoadFile {

    //저장 중인 파일
    private String uploadFileName;
    private String storeFileName;

    //내부에서 이미지는 안 겹치게 만들어야 함
    public UpLoadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }

}
