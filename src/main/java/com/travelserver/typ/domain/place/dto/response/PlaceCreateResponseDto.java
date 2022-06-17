package com.travelserver.typ.domain.place.dto.response;

import com.travelserver.typ.domain.place.dto.request.PlaceCreateRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class PlaceCreateResponseDto {

    String msg;
    PlaceCreateRequestDto data;
}