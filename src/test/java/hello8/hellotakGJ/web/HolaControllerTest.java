package hello8.hellotakGJ.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HolaController.class)
public class HolaControllerTest {

    @Autowired
    private MockMvc mvc;

    //class and method must be public
    @Test
    public void hola() throws Exception {
        String hello = "hola";

        mvc.perform(get("/hola"))
                .andExpect(status().isOk())
                .andExpect(content().string("hola"));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {

        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hola/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}