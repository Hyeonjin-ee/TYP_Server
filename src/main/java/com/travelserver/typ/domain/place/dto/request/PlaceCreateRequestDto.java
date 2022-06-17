package com.travelserver.typ.domain.place.dto.request;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class PlaceCreateRequestDto {
    private int placeId;
    private KwSurvey kwSurvey;
    private Area area;
    private String placeName;
    private String placeDescription;
    private String placeAddress;
    private String placeImage;
    private String placeXCoordinate;
    private String placeYCoordinate;
}