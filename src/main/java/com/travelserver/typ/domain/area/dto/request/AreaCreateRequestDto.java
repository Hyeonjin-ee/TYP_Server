package com.travelserver.typ.domain.area.dto.request;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.place.entity.Place;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter @Setter
@Builder
public class AreaCreateRequestDto {

    private int areaId;
    private Place place;
    private int areaName;
    private String areaAddress;
    private String areaXCoordinate;
    private String areaYCoordinate;


    public Area toEntity(){
        return Area.builder()
                .areaName(areaName)
                .areaAddress(areaAddress)
                .areaXCoordinate(areaXCoordinate)
                .areaYCoordinate(areaYCoordinate)
                .build();
    }

    }

