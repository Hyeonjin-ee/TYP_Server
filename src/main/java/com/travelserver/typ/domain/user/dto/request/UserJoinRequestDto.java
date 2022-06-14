package com.travelserver.typ.domain.user.dto.request;

import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@Builder
public class UserJoinRequestDto {

    private String email;
    private String password;
    private String name;
    private Date brithDate;
    private String phoneNum;
    private boolean gender;

    // 회원 가입
    public User toEntity() {
        return User.builder()
                .brithDate(brithDate)
                .email(email)
                .gender(gender)
                .name(name)
                .password(password)
                .phoneNum(phoneNum)
                .build();
    }
}
