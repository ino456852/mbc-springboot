package com.mbcjava2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbcjava2.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
