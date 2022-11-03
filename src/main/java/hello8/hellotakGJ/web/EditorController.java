package hello8.hellotakGJ.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editor")
public class EditorController {

    @GetMapping("/new1")
    public String new1() {
        return "simpleide/new1";
    }
    @GetMapping("/new2")
    public String new2() {
        return "simpleide/flat";
    }
}
