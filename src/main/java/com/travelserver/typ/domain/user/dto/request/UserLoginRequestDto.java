package com.travelserver.typ.domain.user.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@Builder
public class UserLoginRequestDto {

    private String email;
    private String password;

}
