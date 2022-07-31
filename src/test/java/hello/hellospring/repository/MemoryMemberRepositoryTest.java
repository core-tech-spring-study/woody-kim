package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.mapper.MemberRepository;
import hello.hellospring.mapper.MemoryMemberRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository() {
        @Test
        public void save(@NotNull Member member) {
            Member m = new Member();
            m.setName("김요섭");

            repository.save(m);

            Member result = repository.findById(member.getId()).get();
            Assertions.assertEquals(m, result);
        }

        @Test
        public void findByName(){
            Member member1 = new Member();
            member1.setName("김요섭");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("우디");
            repository.save(member2);

            Member result = repository.findByName("김요섭").get();
            assertThat(result).isEqualTo(member1);
        }
    };
}
