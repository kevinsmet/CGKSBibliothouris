package be.cegeka.bibliothouris.domain.members;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class MemberService {

    @Inject
    private MemberRepository memberRepository;


    public void addMember(Member member){
        if (member.getInsz().isEmpty()||member.getLastName().isEmpty()||member.getCity().isEmpty()) {
            throw new MemberValidationException("Needs to be filled in");
        }
        else if (memberRepository.getAllMembers().contains(member)) {
            throw new MemberValidationException("That member already exists");
        }
        else {
            memberRepository.addMember(member);
        }
    }

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}
