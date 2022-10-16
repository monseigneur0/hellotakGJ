package hello8.hellotakGJ.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RequiredArgsConstructor
public class HolaResponseDto {

    private final String name;
    private final int amount;

}
