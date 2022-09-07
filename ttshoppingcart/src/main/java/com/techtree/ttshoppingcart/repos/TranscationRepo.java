package com.techtree.ttshoppingcart.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techtree.ttshoppingcart.model.Transactions;

public interface TranscationRepo extends JpaRepository<Transactions, Integer> {

	
	@Query(value="select t.CREATION_TIME,t.T_DATE,t.BILL_AMOUNT,t.DISCOUNT_AMOUNT,t.PAID_AMOUNT,o.itemname,o.no_of_item,d.FIRST_NAME,d.LAST_NAME from tt.transactions t inner join tt.users u on t.user_id_id=u.ID inner join tt.orders o on t.order_id_id=o.id inner join tt.userdetails d on u.userdetail_id=d.id;",nativeQuery= true)
	List<Object[]> transcationList();
}
