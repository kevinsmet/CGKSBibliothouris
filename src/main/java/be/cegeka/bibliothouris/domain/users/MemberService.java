package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class MemberService {

    @Inject
    private MemberRepository memberRepository;

    private final AtomicLong counter = new AtomicLong();

    public void addMember(String name){
        memberRepository.addMember(new Member(counter.incrementAndGet() , name));
    }

    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}
