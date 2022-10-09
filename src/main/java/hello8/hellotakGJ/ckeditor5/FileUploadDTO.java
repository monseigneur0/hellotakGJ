package hello8.hellotakGJ.ckeditor5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadDTO {

    private boolean uploaded;
    private String filename;
    private String url;
}
