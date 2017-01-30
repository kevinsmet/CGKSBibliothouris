package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Inject
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Member> getMembers() {
        return memberService.getAllMembers();
    }

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public
    @ResponseBody
    void addMember(@RequestParam(value = "insz", required = true) String insz,
                   @RequestParam(value = "firstName") String firstName,
                   @RequestParam(value = "lastName", required = true) String lastName,
                   @RequestParam(value = "street") String street,
                   @RequestParam(value = "houseNumber") int houseNumber,
                   @RequestParam(value = "postalCode") int postalCode,
                   @RequestParam(value = "city", required = true) String city) {
            Member member = new Member(insz, firstName, lastName, street, houseNumber, postalCode, city);
            memberService.addMember(member);
    }

}


