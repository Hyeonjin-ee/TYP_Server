package com.travelserver.typ.domain.user.dto.response;

import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserJoinResponseDTO {
    String msg;
    Integer userId;
    UserJoinRequestDTO data;
}
