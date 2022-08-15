package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.mapper.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// @Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    /* dependency injection */
    // @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){


            /* 중복회원 검증 */
            memberRepository.findByName(member.getName()).ifPresent(m -> {
                throw new IllegalAccessError("중복된회원입니다.");
            });
            memberRepository.save(member);

        return member.getId();
    }

    public List<Member> findMembers(){

            return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
