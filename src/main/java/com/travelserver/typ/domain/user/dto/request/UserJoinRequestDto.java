package com.travelserver.typ.domain.user.dto.request;

import com.travelserver.typ.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
@Getter
@Setter
@Builder
public class UserJoinRequestDto {
    private String email;
    private String password;
    private String name;
    private Date birthDate;
    private String phoneNum;
    private boolean gender;

    // 회원 가입
    public User toEntity() {
        return User.builder()
                .birthDate(birthDate)
                .email(email)
                .gender(gender)
                .name(name)
                .password(password)
                .phoneNum(phoneNum)
                .build();
    }
}
