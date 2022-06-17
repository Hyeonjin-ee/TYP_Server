package com.travelserver.typ.domain.place.dto.response;

import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.user.dto.response.UserLoginResponseDto;
import com.travelserver.typ.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Builder
public class PlaceSearchResposeDto {

    String msg;
    String name;
    String address;
    String description;

    public static PlaceSearchResposeDto toDto(Place place) {
        return PlaceSearchResposeDto.builder()
                .msg("검색 결과입니다.")
                .name(place.getPlaceName())
                .address(place.getPlaceAddress())
                .description(place.getPlaceDescription())
                .build();
    }
}
