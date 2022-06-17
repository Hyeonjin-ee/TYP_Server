package com.travelserver.typ.domain.user.dto.response;

import com.travelserver.typ.domain.user.dto.request.UserLoginRequestDto;
import com.travelserver.typ.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserLoginResponseDto {

    Boolean loginSucceed;
    Integer userId;
    String email;
    String password;

    public static UserLoginResponseDto toDto(User user) {
        return UserLoginResponseDto.builder()
                .loginSucceed(true)
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
