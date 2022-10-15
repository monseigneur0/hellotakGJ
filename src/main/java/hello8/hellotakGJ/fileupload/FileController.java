package hello8.hellotakGJ.fileupload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class FileController {

    @Value("${file.dir}")
    private String fileDir;

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
    @GetMapping("/uploadv")
    public String testUploadFormv() {

        return "fileupload/fileform";
    }

    /**
     * 김영한 spring uploader
     * @param itemName
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadv")
    public String saveFile(@RequestParam String itemName,
                           @RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        log.info("request={}", request);
        log.info("itemName={}", itemName);
        log.info("multipartFile={}", file);

        //저장
        if (!file.isEmpty()) {
            String fullPath = fileDir + file.getOriginalFilename();
            log.info("파일 저장 fullPath={}", fullPath);
            file.transferTo(new File(fullPath));
        }
        return "redirect:/";
    }
}
