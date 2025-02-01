package com.durgesh.minor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.minor1.model.Txn;

public interface TxnRepository extends JpaRepository<Txn, Integer> {

}
