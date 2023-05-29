package com.kodlamaio.commonpackage.utils.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartOfCarResponse {

    private String plate;
    private int modelYear;
    private String modelName;
    private String brandName;

}
