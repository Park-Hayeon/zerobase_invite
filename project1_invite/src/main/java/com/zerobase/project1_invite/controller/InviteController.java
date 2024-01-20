package com.zerobase.project1_invite.controller;

import com.zerobase.project1_invite.dto.InviteRequestDto;
import com.zerobase.project1_invite.dto.MemberStatus;
import com.zerobase.project1_invite.dto.ResponseDto;
import com.zerobase.project1_invite.entity.MemberEntity;
import com.zerobase.project1_invite.service.InviteService;
import com.zerobase.project1_invite.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/invite")
@RequiredArgsConstructor
public class InviteController {

    private final InviteService inviteService;

    // 참여자 초대
    @PostMapping("")
    public ResponseEntity<ResponseDto> inviteMember(@RequestBody InviteRequestDto dto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(Util.generateUUID());
        memberEntity.setName(dto.getName());
        memberEntity.setPhone(dto.getPhone());
        memberEntity.setEmail(dto.getEmail());
        memberEntity.setStatus(MemberStatus.TEMP.getCode());
        memberEntity.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));

        return ResponseEntity.ok(inviteService.inviteMember(memberEntity));
    }

    // 초대 수락
    @PutMapping("")
    public ResponseEntity<ResponseDto> inviteAccept(@RequestBody String id) {
        return ResponseEntity.ok(inviteService.inviteAccept(id));
    }

    // 초대 거절
    @DeleteMapping("")
    public ResponseEntity<ResponseDto> inviteRefuse(@RequestBody String id) {
        System.out.println("id = " + id);
        return ResponseEntity.ok(inviteService.inviteRefuse(id));
    }

}
