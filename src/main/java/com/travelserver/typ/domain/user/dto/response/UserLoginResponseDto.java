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

    String msg;
    Integer userId;
    String email;

    public static UserLoginResponseDto toDto(User user) {
        return UserLoginResponseDto.builder()
                .msg("로그인 성공했습니다.")
                .userId(user.getUserId())
                .email(user.getEmail())
                .build();
    }

}
