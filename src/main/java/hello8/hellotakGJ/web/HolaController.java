package hello8.hellotakGJ.web;

import hello8.hellotakGJ.web.dto.HolaResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

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
