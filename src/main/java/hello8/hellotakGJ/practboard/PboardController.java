package hello8.hellotakGJ.practboard;

import hello8.hellotakGJ.domain.Address;
import hello8.hellotakGJ.domain.Member;
import hello8.hellotakGJ.web.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/p")
public class PboardController {

    private final PboardService pboardService;
    private final PMemberService pMemberService;

    @GetMapping("/pboards")
    public String pboardList(Model model) {
        List<Pboard> pboards =  pboardService.findBoards();
        model.addAttribute("pboards", pboards);
        return "pboard/pboards";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pboardForm", new PboardForm());
        return "pboard/create";
    }

    @PostMapping("/create")
    public String createPost(@Valid Pboard pboard,  BindingResult result) {
        if (result.hasErrors()) {
            return "pboard/create";
        }

        pboardService.createcontent(pboard);

        return "redirect:/p/pboards";
    }

    @GetMapping("/createpmember")
    public String createPMember(Model model) {
        model.addAttribute("pmemberForm", new PMemberForm());
        return "pboard/createpmember";
    }
    @PostMapping("/createpmember")
    public String createPostPMember(@Valid PMember pMember,  BindingResult result) {
        if (result.hasErrors()) {
            return "pboard/createpmember";
        }

        pMemberService.createMember(pMember);

        return "redirect:/p/pboards";
    }
}
