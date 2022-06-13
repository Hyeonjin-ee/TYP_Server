package com.travelserver.typ.domain.kwsurvey.entity;

import com.travelserver.typ.domain.place.entity.Place;
import com.travelserver.typ.domain.teamjoin.entity.TeamJoin;
import com.travelserver.typ.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "\"keyword\"")
public class KwSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kw_id")
    private long keywordId;

    @OneToOne(mappedBy = "keyword")
    private User user;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Place> places = new ArrayList<>();

    private int withNum;

    private int houseStyle;

    private int foodPrice;

    private int nature;

    private int history;

    private int resting;

    private int performance;

    private int culture;

    private int leports;

    private int shopping;

    private int food;

}
