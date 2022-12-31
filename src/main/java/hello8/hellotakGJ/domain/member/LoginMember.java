package hello8.hellotakGJ.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginMember {

    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;
}
