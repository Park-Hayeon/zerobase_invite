package com.zerobase.project1_invite.service;

import com.zerobase.project1_invite.dto.MemberStatus;
import com.zerobase.project1_invite.dto.ResponseDto;
import com.zerobase.project1_invite.entity.MemberEntity;
import com.zerobase.project1_invite.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InviteService {

    private final MemberRepository memberRepository;

    private final Map<String, URL> urlMap = new HashMap<>();

    public ResponseDto inviteMember(MemberEntity memberEntity) {
        ResponseDto responseDto;
        MemberEntity saveMember = memberRepository.save(memberEntity);

        URL url = null;
        if (saveMember.getId() != null) {
            // 초대 링크 생성
            url = generateInviteLink();
            urlMap.put(memberEntity.getId(), url);
            responseDto = ResponseDto.builder().success(true).message("초대 링크가 생성되었습니다.").url(url).memberEntity(saveMember).build();
        } else {
            // DB 저장 실패
            responseDto = ResponseDto.builder().success(false).message("초대 링크가 생성되지 못했습니다.").build();
        }

        return responseDto;
    }

    public URL generateInviteLink() {
        URL url = null;

        try {
            url = new URL("http://localhost:8888/index.html");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return url;
    }

    public ResponseDto inviteAccept(String id) {
        ResponseDto responseDto = new ResponseDto();

        // status 변경
        Optional<MemberEntity> findMember = memberRepository.findById(id);
        if(findMember.isPresent()){
            MemberEntity memberEntity = findMember.get();
            memberEntity.setStatus(MemberStatus.ACTIVE.getCode());

            MemberEntity updateMember = memberRepository.save(memberEntity);
            // 초대 링크 만료 처리
            urlMap.remove(id);
            responseDto = ResponseDto.builder().success(true).message("정상 처리 되었습니다.").memberEntity(updateMember).build();
        }

        return responseDto;
    }

    public ResponseDto inviteRefuse(String id) {
        // DB 삭제
        memberRepository.deleteById(id);
        return ResponseDto.builder().success(true).message("정보가 삭제되었습니다.").build();
    }

    @Scheduled(cron = "0 0 0 * * ?")
    private void checkExpiredUrl() {
        // 수락되지 않은 초대 링크 주기적으로 확인
        log.info("checkExpiredUrl");
    }


}
