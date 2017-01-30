package be.cegeka.bibliothouris.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MemberServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public ExpectedException exRule = ExpectedException.none();

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    public void addMember_ShouldCallUserRepository() throws Exception {
        memberService.addMember(new Member("5l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt"));
        verify(memberRepository).addMember(new Member("5l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt"));
    }

    @Test
    public void getAllMembers() throws Exception {
        Member member1 = new Member("1l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt");
        Member member2 = new Member("2l", "Sanne", "Ha", "jowjow", 48, 8852, "Nice");
        Member member3 = new Member("3l", "Xan", "Vranckaert", "Schoolstraat", 78 , 1745, "Opwijk");

        when(memberRepository.getAllMembers()).thenReturn(Arrays.asList(member1, member2, member3));
        assertThat(memberService.getAllMembers()).containsOnly(member1, member2, member3);
    }

    @Test
    public void addMemberEx_throwsEmptyFieldException () throws Exception {
        exRule.expectMessage("Needs to be filled in");
        memberService.addMember(new Member("", "Xan", "Vranckaert", "Schoolstraat", 78 , 1745, "Opwijk"));
    }

    @Test
    public void addMemberExAgain_throwsEmptyFieldException () throws Exception {
        Member member1 = new Member("1l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt");
        Member member2 = new Member("2l", "Sanne", "Ha", "jowjow", 48, 8852, "Nice");
        Member member3 = new Member("3l", "Xan", "Vranckaert", "Schoolstraat", 78 , 1745, "Opwijk");

        exRule.expectMessage("That member already exists");
        when(memberRepository.getAllMembers()).thenReturn(Arrays.asList(member1, member2, member3));
        memberService.addMember(new Member("3l", "Xan", "Vranckaert", "Schoolstraat", 78 , 1745, "Opwijk"));

    }
}

/*
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
 */