package com.zerobase.project1_invite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Table(name = "member")
@Entity
@Data
public class MemberEntity {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private Integer status;
    private Timestamp createDate;
}
