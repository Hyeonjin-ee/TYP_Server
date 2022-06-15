package com.travelserver.typ.domain.area.respository;

import com.travelserver.typ.domain.area.dto.request.AreaSelectedRequestDto;
import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Integer> {

}
