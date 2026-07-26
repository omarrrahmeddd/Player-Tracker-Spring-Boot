package com.koora.repo;

import com.koora.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepo extends JpaRepository<Club,Integer> {
}
