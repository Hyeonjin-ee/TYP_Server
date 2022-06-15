package com.travelserver.typ.controller;

import com.travelserver.typ.domain.area.dto.request.AreaCreateRequestDto;
import com.travelserver.typ.domain.area.dto.response.AreaCreateResponseDto;
import com.travelserver.typ.domain.area.dto.response.AreaSelectedResponseDto;
import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.area.respository.AreaRepository;
import com.travelserver.typ.domain.area.service.AreaService;
import com.travelserver.typ.domain.place.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SeoulController implements AreaController{

    @Autowired
    private final AreaService areaService;
    @Autowired
    private final PlaceService placeService;


    // 지도 선택
    @GetMapping("{areaId}")
    @ResponseBody
    public AreaCreateResponseDto createAreaInfo(@PathVariable("areaId") Integer areaName, @RequestBody AreaCreateRequestDto dto){
        // Area Create
        Area area = areaService.createArea(dto);

        AreaCreateRequestDto areaInfoInDB = AreaCreateRequestDto.builder()
                .areaName(area.getAreaName())
                .areaAddress(area.getAreaAddress())
                .areaXCoordinate(area.getAreaXCoordinate())
                .areaYCoordinate(area.getAreaYCoordinate())
                .build();

        AreaCreateResponseDto responseDto = AreaCreateResponseDto.builder()
                .areaMsg(area.getAreaName() + "이 선택되었습니다.")
                .data(areaInfoInDB)
                .build();

        return responseDto;
    }

}
