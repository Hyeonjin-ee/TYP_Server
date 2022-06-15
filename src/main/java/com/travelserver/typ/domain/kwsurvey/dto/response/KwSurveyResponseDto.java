package com.travelserver.typ.domain.kwsurvey.dto.response;

import com.travelserver.typ.domain.kwsurvey.dto.request.KwSurveyRequestDto;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Builder
public class KwSurveyResponseDto {

    Place place;
    String msg;
    Long kwId;
    KwSurveyRequestDto data;
}
