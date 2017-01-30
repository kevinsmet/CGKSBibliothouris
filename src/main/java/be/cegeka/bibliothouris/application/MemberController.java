package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.Member;
import be.cegeka.bibliothouris.domain.users.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MemberController {

    @Inject
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Member> getMembers() {
        return memberService.getAllMembers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addMember(@RequestParam(value = "name", required = true) String name) {
        memberService.addMember(name);
    }

}
