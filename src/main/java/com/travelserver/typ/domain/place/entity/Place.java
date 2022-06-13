package com.travelserver.typ.domain.place.entity;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import com.travelserver.typ.domain.team.entity.Team;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "\"place\"")
public class Place {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private int placeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kw_id")
    private KwSurvey kwSurvey;

    @OneToOne
    @JoinColumn(name = "area_id")
    private Area area;

    private String placeName;

    private String placeDescription;

    private String placeImage;

}
