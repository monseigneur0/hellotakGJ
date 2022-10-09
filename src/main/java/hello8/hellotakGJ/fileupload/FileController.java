package hello8.hellotakGJ.fileupload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class FileController {

    private final FileService fileService;


    @GetMapping("/uploadk")
    public String testUploadForm() {

        return "fileupload/fileform";
    }

    @PostMapping("/uploadk")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files) throws IOException {
        fileService.saveFile(file);

        for (MultipartFile multipartFile : files) {
            fileService.saveFile(multipartFile);
            log.debug("fileuploaded");

        }
        log.debug("fileuploaded");
        return "redirect:/";
    }

}
