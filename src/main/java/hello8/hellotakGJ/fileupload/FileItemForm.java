package hello8.hellotakGJ.fileupload;

import lombok.Data;

import java.util.List;

@Data
public class FileItemForm {

    //업로드 하려는 파일
    private Long id;
    private String itemName;
    private UpLoadFile attachFile;
    private List<UpLoadFile> imageFiles;
    // 이미지 같은 경우는 여러개의 파일을 업로드 할 수 있어야 함
}
