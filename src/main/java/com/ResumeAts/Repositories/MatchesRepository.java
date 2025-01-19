package com.ResumeAts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResumeAts.entity.matches;


@Repository
public interface  MatchesRepository  extends JpaRepository< matches ,Long>{

	
}
