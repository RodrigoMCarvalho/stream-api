package com.dev.java8;

import java.util.Arrays;

public enum TipoEnum {

    SIM("S", "sim"),
    NAO("N", "não"),
    TALVEZ("T", "talvez"),
    ERROR("E", "error"),
    NAO_ENCONTRADO("NE", "não encontrado");

    private final String status;
    private final String value;

    TipoEnum(String status, String value) {
        this.status = status;
        this.value = value;
    }

    public static String obterValue(String status) {
        return Arrays.stream(TipoEnum.values())
                .filter(s -> s.getStatus().equals(status))
                .map(TipoEnum::getValue)
                .findFirst().orElse(NAO_ENCONTRADO.getValue());
    }

    public String getStatus() {
        return status;
    }

    public String getValue() {
        return value;
    }
}
