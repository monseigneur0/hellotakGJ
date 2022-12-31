package hello8.hellotakGJ;

import hello8.hellotakGJ.domain.item.Item;
import hello8.hellotakGJ.domain.member.LoginMember;
import hello8.hellotakGJ.domain.member.LoginMemberRepository;
import hello8.hellotakGJ.repository.ItemRepository;
import hello8.hellotakGJ.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class testdatainit {
    private final ItemRepository itemRepository;
    private final LoginMemberRepository memberRepository;
    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        LoginMember member = new LoginMember();
        member.setLoginId("test");
        member.setPassword("test");
        member.setName("테스터");
        memberRepository.save(member);
    }
}
