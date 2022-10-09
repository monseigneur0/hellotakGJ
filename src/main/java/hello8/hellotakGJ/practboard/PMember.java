package hello8.hellotakGJ.practboard;

import hello8.hellotakGJ.domain.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class PMember {


    @Id
    @GeneratedValue
    @Column(name = "pmember_id")
    private Long id;

    private String name;

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    @OneToMany(mappedBy = "pMember")
    private List<Pboard> pboards = new ArrayList<>();

}
