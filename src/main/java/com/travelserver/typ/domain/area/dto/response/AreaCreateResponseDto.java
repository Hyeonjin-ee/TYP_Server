package com.travelserver.typ.domain.area.dto.response;


import com.travelserver.typ.domain.area.dto.request.AreaCreateRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Builder
public class AreaCreateResponseDto {

    String areaMsg;
    int areaId;
    boolean isSelected;
    AreaCreateRequestDto data;
}
