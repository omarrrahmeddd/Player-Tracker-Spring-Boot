package com.koora.repo;

import com.koora.entity.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepo extends JpaRepository<Nationality,Integer> {
}
