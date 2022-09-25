package hello8.hellotakGJ.web;

import hello8.hellotakGJ.domain.MyBatis;
import hello8.hellotakGJ.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyBatisController {

    @Autowired
    private MyBatisService myBatisService;


    @GetMapping("/mybatis")
    public String mybatis(Model model) {

        List<MyBatis> mybatisList = myBatisService.getAllMember();
        model.addAttribute("mybatis", mybatisList);
        return "mybatis/mybatis";
    }
}
