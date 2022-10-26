package hello8.hellotakGJ.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HolaResponseDtoTest {

    @Test
    public void lomboktest() {
        //given
        String name = "test";
        int amount = 1000;

        //when

        HolaResponseDto dto = new HolaResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}