package com.zerobase.project1_invite.dto;

import com.zerobase.project1_invite.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseDto {
    private boolean success;
    private String message;
    private URL url;
    private MemberEntity memberEntity;
}
