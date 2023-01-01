package hello8.hellotakGJ.web;

import hello8.hellotakGJ.domain.member.LoginMember;
import hello8.hellotakGJ.domain.member.LoginMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final LoginMemberRepository memberRepository;

    //@RequestMapping("/home")
    public String home() {
        log.info("home controller");
        return "home";
    }

    @GetMapping("/home")
    public String homeLogin(
            @CookieValue(name = "memberId", required = false) Long memberId,
            Model model) {
        if (memberId == null) {
            return "home";
        }
//로그인
        LoginMember loginMember = memberRepository.findById(memberId); if (loginMember == null) {
            return "home";
        }
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
