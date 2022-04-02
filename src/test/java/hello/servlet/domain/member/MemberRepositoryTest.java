package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = MemberRepository.getInstance();
    }

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    @DisplayName("Member 를 저장하고 store 와 비교했을 때 저장된 멤버와 찾아온 멤버가 같아야 한다.")
    void save() {
        Member test1 = new Member("test1", 20);
        Member saveMember = repository.save(test1);
        Member findMember = repository.findById(saveMember.getId());

        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    @DisplayName("Member 를 저장하고 store 에 저장된 멤버 Id 와 저장한 멤버 Id 가 같아야 한다.")
    void findById() {
        Member test1 = new Member("test1", 20);
        Member saveMember = repository.save(test1);

        assertThat(saveMember.getId()).isEqualTo(test1.getId());
    }

    @Test
    @DisplayName("여러 멤버를 저장하면서 사이즈를 비교했을 때 저장한 멤버만큼의 사이즈가 나오고, 각 인덱스 별 username 이 같아야 한다. ")
    void findAll() {
        Member test1 = new Member("test1", 20);
        Member test2 = new Member("test2", 30);

        Member saveMember1 = repository.save(test1);
        Member saveMember2 = repository.save(test2);

        List<Member> allMember = repository.findAll();

        assertThat(allMember.size()).isEqualTo(2);
        assertThat(allMember.get(0).getUsername()).isEqualTo(saveMember1.getUsername());
        assertThat(allMember.get(1).getUsername()).isEqualTo(saveMember2.getUsername());
    }
}