package com.travelserver.typ.csvprocessor.dto;

import com.travelserver.typ.domain.area.entity.Area;
import com.travelserver.typ.domain.kwsurvey.entity.KwSurvey;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
public class PlaceCsvDto {

    private int placeId;
    private long keywordId;
    private int areaId;
    private String placeName;
//    private String placeDescription;
    private String placeAddress;
//    private String placeImage;


    private String category;
    private int withNum;
    private int age;
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
