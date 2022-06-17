package com.travelserver.typ.domain.area.service;

import com.travelserver.typ.domain.area.dto.request.AreaCreateRequestDto;
import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.area.repository.AreaRepository;
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


    @Transactional
    public Area createArea(AreaCreateRequestDto dto) {
        return areaRepository.save(dto.toEntity());
    }
}
