package hello8.hellotakGJ.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditorController {

    @GetMapping("/new1")
    public String new1() {
        return "simpleide/new1";
    }
    @GetMapping("/flat")
    public String newflat() {
        return "simpleide/flat";
    }

    @GetMapping("/new2")
    public String new2() {
        return "simpleide/new2";
    }
    @GetMapping("/")
    public String new31() {
        return "simpleide/new3";
    }
    @GetMapping("/new3")
    public String new3() {
        return "simpleide/new3";
    }
    @GetMapping("/new4")
    public String new4() {
        return "simpleide/new4";
    }
}
