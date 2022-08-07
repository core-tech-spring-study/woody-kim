package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.mapper.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Commit
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("rrrtttttrrrrr55555rt");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("김요섭422444");

        Member member2 = new Member();
        member2.setName("김요섭244444244");

        memberService.join(member1);

        //when
        try{
            memberService.join(member2);
        }catch (IllegalAccessError e){
            /* 예외 처리 */
            System.out.println(e.getMessage());
        }

        //then
    }
}