package com.mbcjava2.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_generator") // PK 값 자동 생성 전략
    @SequenceGenerator(name = "board_seq_generator", sequenceName = "SEQ_TBL_BOARD", allocationSize = 1) // 오라클 시퀀스 매핑
	private int bno;
	
	@Column(length = 200,nullable = false)
	private String title;
	
	@Column(length = 50,nullable = false)
	private String writer;
	
	@Column(length = 4000,nullable = false)
	private String content;
	
	@CreationTimestamp // 엔티티가 처음 저장될 때 현재 시간
	private LocalDateTime regDt;
	
}
