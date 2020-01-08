package com.vts.respository.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vts.beans.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
