package com.abcmover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcmover.entity.Vessel;

@Repository
public interface VesselRepository extends JpaRepository<Vessel, Long> {

}
