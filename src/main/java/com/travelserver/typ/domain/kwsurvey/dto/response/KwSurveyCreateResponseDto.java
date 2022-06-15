package com.travelserver.typ.domain.kwsurvey.dto.response;

import com.travelserver.typ.domain.kwsurvey.dto.request.KwSurveyCreateRequestDto;
import com.travelserver.typ.domain.user.dto.request.UserJoinRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class KwSurveyCreateResponseDto {

    String msg;
    Integer userId;
    String userName;
    Long keywordId;
    KwSurveyCreateRequestDto data;

}
