package com.abcmover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcmover.entity.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

}
