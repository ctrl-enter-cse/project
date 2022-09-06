package com.techtree.ttshoppingcart.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.techtree.ttshoppingcart.model.Users;


@org.springframework.stereotype.Repository
public interface Repository extends  JpaRepository<Users,Long> {
	


}
