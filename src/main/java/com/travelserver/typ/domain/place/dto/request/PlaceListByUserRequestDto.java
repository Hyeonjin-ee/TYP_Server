package com.travelserver.typ.domain.place.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class PlaceListByUserRequestDto {

    private int userId;
    private long keywordId;

    // 유저가 선택한 지역 정보
    private int areaId;

}
