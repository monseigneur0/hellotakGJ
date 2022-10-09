package hello8.hellotakGJ.practboard;

import hello8.hellotakGJ.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pboard {

    @Id @GeneratedValue
    @Column(name = "pboard_id")
    public Long id;

    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private int hits; // 조회 수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifiedDate; // 수정일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pmember_id")
    private PMember pMember;

    public Pboard(String boardA) {
        this.setTitle(boardA);

    }
}
