package be.cegeka.bibliothouris.domain.members;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
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

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(memberService, "counter", new AtomicLong(4l));
    }

    @Test
    public void addMember_ShouldCallUserRepository() throws Exception {
        //memberService.addMember("Seppe");

        verify(memberRepository).addMember(new Member("5l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt"));
    }

    @Test
    public void getAllMembers() throws Exception {
        Member member1 = new Member("1l", "Seppe", "Gielen", "Somewhere", 69, 8460, "Hasselt");
        Member member2 = new Member("2l", "Sanne", "Ha", "jowjow", 48, 8852, "Nice");
        Member member3 = new Member("3l", "Xan", "Vranckaert", "Schoolstraat", 78 , 1745, "Opwijk");

        when(memberRepository.getAllMembers()).thenReturn(Arrays.asList(member1, member2));

        assertThat(memberService.getAllMembers()).containsOnly(member1, member2);
    }
}