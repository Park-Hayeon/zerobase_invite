package com.zerobase.project1_invite.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum MemberStatus {
    TEMP(0),
    ACTIVE(1),
    DORMANT(2);

    private final int code;

    private MemberStatus(int code) {
        this.code = code;
    }

    @JsonValue
    public int toValue() {
        return this.getCode();
    }

}
