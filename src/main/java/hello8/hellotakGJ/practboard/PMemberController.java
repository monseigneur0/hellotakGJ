package hello8.hellotakGJ.practboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PMemberController {

    private final PMemberService pMemberService;

    @GetMapping("/pmembers")
    public String pmember(Model model) {
        List<PMember> allmembers = pMemberService.allMembers();
        model.addAttribute("pmembers", allmembers);
        return "pboard/pmembers";
    }
}
