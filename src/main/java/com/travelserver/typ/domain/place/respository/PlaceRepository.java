package com.travelserver.typ.domain.place.respository;

import com.travelserver.typ.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
