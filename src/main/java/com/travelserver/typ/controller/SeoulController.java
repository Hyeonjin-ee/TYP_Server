package com.travelserver.typ.controller;

import com.travelserver.typ.domain.area.dto.request.AreaCreateRequestDto;
import com.travelserver.typ.domain.area.dto.response.AreaCreateResponseDto;
import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.area.service.AreaService;
import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/area")
@RequiredArgsConstructor
public class SeoulController implements AreaController{

    @Autowired
    private final AreaService areaService;
    @Autowired
    private final PlaceService placeService;


    // 지도 선택
    @PostMapping("{placeId}")
    @ResponseBody
    public AreaCreateResponseDto createAreaInfo(@PathVariable("placeId") Integer placeId, @RequestBody AreaCreateRequestDto dto){
        Place place = placeService.getPlace(placeId);

        // Area Create
        Area area = areaService.createArea(dto);

        // Area를 place에게 부여하기 (place Info update)
        placeService.updatePlaceAreaId(area, place);

        AreaCreateRequestDto areaInfoInDB = AreaCreateRequestDto.builder()
                .areaName(area.getAreaName())
                .areaAddress(area.getAreaAddress())
                .areaXCoordinate(area.getAreaXCoordinate())
                .areaYCoordinate(area.getAreaYCoordinate())
                .build();

        AreaCreateResponseDto responseDto = AreaCreateResponseDto.builder()
                .areaMsg(area.getAreaName() + "이 선택되었습니다.")
                .areaId(area.getAreaId())
                .data(areaInfoInDB)
                .build();

        return responseDto;
    }

}
