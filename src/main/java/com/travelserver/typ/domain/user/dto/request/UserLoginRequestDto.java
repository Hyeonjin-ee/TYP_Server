package com.travelserver.typ.domain.user.dto.request;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequestDto {

    private String email;
    private String password;

}
