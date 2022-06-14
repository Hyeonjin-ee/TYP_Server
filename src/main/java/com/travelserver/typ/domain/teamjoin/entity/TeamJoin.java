package com.travelserver.typ.domain.teamjoin.entity;

import com.travelserver.typ.domain.team.entity.Team;
import com.travelserver.typ.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "team_join")
public class TeamJoin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_join_id")
    private int teamJoinId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
