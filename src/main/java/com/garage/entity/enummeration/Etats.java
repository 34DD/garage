package com.garage.entity.enummeration;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;


public enum     Etats {
    @JsonEnumDefaultValue
    EN_FILE_D_ATTENTE,
    PRIS_EN_CHARGE,
    MIS_A_DISPOSITION;

}