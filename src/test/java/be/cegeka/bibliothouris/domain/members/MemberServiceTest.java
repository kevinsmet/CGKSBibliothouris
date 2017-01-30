package be.cegeka.bibliothouris.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
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

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

<<<<<<< HEAD
    private List<Member> members = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Member member1 = new Member("10", "William","Alegria", "Henri Liebrechtlaan",39,1090, "Jette");
        Member member2 = new Member("20", "William2","Alegria", "Henri Liebrechtlaan",39,1090, "Jette");
        Member member3 = new Member("30", "William","Alegria", "Henri Liebrechtlaan",39,1090, "Jette");
        members.addAll(Arrays.asList(member1,member2,member3));
    }

    @Test
    public void addMember_ShouldCallUserRepository() throws Exception {
        memberService.addMember(members.get(0));
        verify(memberRepository).addMember(members.get(0));
    }

    @Test
    public void addMember_ValidateExistingUser() throws Exception{
        Member member4 = new Member("30", "Willy","Aly", "Henri",39,1090, "Jette");
//        Member member5 = new Member("", "William","", "Henri Liebrechtlaan",39,1090, "");
        when(memberRepository.getAllMembers()).thenReturn(members);
        Assertions.assertThat(memberService.addMember(member4)).;
        /*
         if (member.getInsz().isEmpty()||member.getLastName().isEmpty()||member.getCity().isEmpty()) {
            throw new MemberValidationException("Needs to be filled in");
        }
        else if (memberRepository.getAllMembers().contains(member)) {
            throw new MemberValidationException("That member already exists");
        }
        else {
            memberRepository.addMember(member);
         */
=======
    @Test
    public void addMember_ShouldCallUserRepository() throws Exception {
        memberService.addMember(new Member("5l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt"));
        verify(memberRepository).addMember(new Member("5l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt"));
>>>>>>> e61e59704264f5177ae9d26e8ae6f78b24e8bbfd
    }

    @Test
    public void getAllMembers() throws Exception {
<<<<<<< HEAD
=======
        Member member1 = new Member("1l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt");
        Member member2 = new Member("2l", "Sanne", "Ha", "jowjow", 48, 8852, "Nice");
        Member member3 = new Member("3l", "Xan", "Vranckaert", "Schoolstraat", 78 , 1745, "Opwijk");
>>>>>>> e61e59704264f5177ae9d26e8ae6f78b24e8bbfd

        when(memberRepository.getAllMembers()).thenReturn(Arrays.asList(member1, member2));

        assertThat(memberService.getAllMembers()).containsOnly(member1, member2);
    }
}