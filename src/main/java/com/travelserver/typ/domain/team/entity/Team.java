package com.travelserver.typ.domain.team.entity;

import com.travelserver.typ.domain.teamjoin.entity.TeamJoin;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "team")
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

//    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, targetEntity = TeamJoin.class)
//    private List<TeamJoin> teamJoins = new ArrayList<>();

}
