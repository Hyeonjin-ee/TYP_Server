package com.travelserver.typ.domain.area.entity;

import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "\"area\"")
public class Area {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private int areaId;

    @OneToOne(mappedBy = "place")
    private Place place;

    private int areaName;
    
    private String areaAddress;

    private int selectedNum;

}
