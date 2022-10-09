/*
package hello8.hellotakGJ.ckeditor5;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/image/upload")
    public FileUploadDTO imageUpLoad(@RequestPart MultipartFile upload, Principal principal) throws IOException {

        return fileService.fileUpLoad(upload, principal);
    }
}
*/
