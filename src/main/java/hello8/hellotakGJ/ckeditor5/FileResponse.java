package hello8.hellotakGJ.ckeditor5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileResponse {
    private boolean uploaded;
    private String url;
}
