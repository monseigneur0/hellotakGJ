package hello8.hellotakGJ.web;

import hello8.hellotakGJ.web.dto.HolaResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello";
    }
    @GetMapping("/hola")
    public String hola() {
        return "hola";
    }

    @GetMapping("/hola/dto")
    public HolaResponseDto holaDto(@RequestParam("name") String name,
                                   @RequestParam("amount") int amount) {
        return new HolaResponseDto(name, amount);
    }
}
