package com.travelserver.typ.domain.user.dto.response;

import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserJoinResponseDto {

    String msg;
    Integer userId;
    UserJoinRequestDto data;

}
