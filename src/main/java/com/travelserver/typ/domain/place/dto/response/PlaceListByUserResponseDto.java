package com.travelserver.typ.domain.place.dto.response;

import com.travelserver.typ.domain.place.dto.request.PlaceListByUserRequestDto;
import com.travelserver.typ.domain.place.entity.Place;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Data
@Getter
@Setter
@Builder
public class PlaceListByUserResponseDto {

    private String msg;
    private PlaceListByUserRequestDto dto;
    private List<Place> allPlaces;
    private List<Place> housePlaces;
    private List<Place> foodPlaces;
    private List<Place> playPlaces;

}
