package hello8.hellotakGJ.fileupload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class FileItemController {

    private final FileRepository itemRepository;
    private final FileStore fileStore;

    @GetMapping("/newfile")
    public String newItem(@ModelAttribute FileItemForm form) {
        return "item-form";
    }

    /*@PostMapping("/new")
    public String saveItem(@ModelAttribute FileItemForm form, RedirectAttributes redirectAttributes) throws IOException {

        UpLoadFile attachFile = fileStore.storeFile(form.getAttachFile());
        List<UpLoadFile> storeImageFiles = fileStore.storeFiles(form.getImageFiles());

        //DB저장
        FileItemForm item = new FileItemForm();
        item.setItemName(form.getItemName());
        item.setAttachFile(attachFile);
        item.setImageFiles(storeImageFiles);
        redirectAttributes.addAttribute("itemid", item.getId());
        return "redirect:/items/{itemId}";
    }*/

    @GetMapping("/{id}")
    public String items(@PathVariable Long id, Model model) {

        Optional<FileEntity> item = itemRepository.findById(id);
        model.addAttribute("item", item);
        return "item-view";

    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file" + fileStore.getFullPath(filename));
    }

    /*@GetMapping("/attach/{itemId}")
    public ResponseEntity<Resource> downloadAttach(@PathVariable Long itemId) throws MalformedURLException {

        FileItemForm item = itemRepository.findById(itemId);
        String storeFileName = item.getAttachFile().getStoreFileName();
        String uploadFileName = item.getAttachFile().getUploadFileName();

        UrlResource resource = new UrlResource("file:" + fileStore.getFullPath(storeFileName));

        log.info("uploadFileName={}", uploadFileName);
        String encodedUploadFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=" + encodedUploadFileName + "\"";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }*/
}
