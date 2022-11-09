package com.example.springboot.NoleggioAutoSpringBoot.repository;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AutoRepository extends JpaRepository<Auto, Long> {

    List<Auto> findAllByIdNotIn(List<Long> idList);

}
