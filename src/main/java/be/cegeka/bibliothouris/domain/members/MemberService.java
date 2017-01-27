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
        if (member.getInsz().equals(null)||member.getLastName().equals(null)||member.getCity().equals(null))
            throw new MemberValidationException("Needs to be filled in");
        memberRepository.addMember(new Member(member))
        ));
    }

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}
