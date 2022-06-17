package com.travelserver.typ.domain.user.entity;

import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "user")
public class User {

    @Id
    // Field 'user_id' doesn't have a default value error 해결 : IDENTITY -> AUTO
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public int userId;

    @OneToOne
    @JoinColumn(name = "kw_id")
    public KwSurvey kwSurvey;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = TeamJoin.class)
//    private List<TeamJoin> teamJoins = new ArrayList<>();

    @Column(name = "user_email")
    public String email;

    @Column(name = "user_pwd")
    public String password;

    @Column(name = "user_name")
    public String name;

    @Column(name = "user_birthdate")
    public Date birthDate;

    @Column(name = "user_phonenum")
    public String phoneNum;

    @Column(name = "user_gender")
    public boolean gender;

    @Column(name = "user_status")
    public boolean status;

    @Column(name = "user_image")
    public String userImg;


    public void update(KwSurvey kwSurvey) {
        this.kwSurvey = kwSurvey;
//        kwSurvey.update(this);
    }

}
