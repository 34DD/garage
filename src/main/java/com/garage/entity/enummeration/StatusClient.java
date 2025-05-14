package com.garage.entity.enummeration;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum StatusClient{
    //SIMPLE,
    @JsonEnumDefaultValue
    SILVER,
    GOLD,
    PLATINIUM
}
