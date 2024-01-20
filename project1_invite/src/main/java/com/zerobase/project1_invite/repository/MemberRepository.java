package com.zerobase.project1_invite.repository;

import com.zerobase.project1_invite.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}
