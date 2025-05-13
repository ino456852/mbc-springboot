package com.mbcjava2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbcjava2.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{

}
