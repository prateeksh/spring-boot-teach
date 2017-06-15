package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Prateek on 6/15/2017.
 */

@Repository
public interface TeachRepository extends JpaRepository<TeachData, Long> {
}
