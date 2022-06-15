package com.travelserver.typ.domain.area.service;

import com.travelserver.typ.domain.area.dto.request.AreaCreateRequestDto;
import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.area.respository.AreaRepository;
import com.travelserver.typ.domain.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AreaService {

    @Autowired
    private final AreaRepository areaRepository;
    @Autowired
    private final PlaceRepository placeRepository;

    @Transactional
    public Area createArea(AreaCreateRequestDto dto){
        Area area = Area.builder()
                .areaName(dto.getAreaName())
                .areaAddress(dto.getAreaAddress())
                .areaXCoordinate(dto.getAreaXCoordinate())
                .areaYCoordinate(dto.getAreaYCoordinate())
                .build();
        return areaRepository.save(area);
    }
}
