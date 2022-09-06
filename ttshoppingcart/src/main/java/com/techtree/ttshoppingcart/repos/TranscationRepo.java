package com.techtree.ttshoppingcart.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtree.ttshoppingcart.model.Transactions;

public interface TranscationRepo extends JpaRepository<Transactions, Integer> {

}
