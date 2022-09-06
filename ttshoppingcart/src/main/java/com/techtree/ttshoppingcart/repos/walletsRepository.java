package com.techtree.ttshoppingcart.repos;

import java.util.Date;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.techtree.ttshoppingcart.model.Wallets;
@Repository
public interface walletsRepository extends  JpaRepository<Wallets,Long>{

	@Query(value="SELECT\n"
			+ "w.ID,\n"
			+ "w.EXPIRY_CASHBACK_DATE_TIME,\n"
			+ "w.AMOUNT_STATUS,\n"
			+ "t.PAID_AMOUNT,\n"
			+ "w.AMOUNT,\n"
			+ "t.TRANSCATION_STATUS,\n"
			+ "u.EMAIL,\n"
			+ "d.FIRST_NAME,\n"
			+ "d.LAST_NAME,\n"
			+ "u.PHONENUMBER\n"
			+ "FROM tt.wallets w\n"
			+ "JOIN tt.transactions t\n"
			+ "  ON w.trancation_id_id = t.id\n"
			+ "JOIN tt.users u\n"
			+ "  ON w.user_id_id =  u.id\n"
			+ "JOIN tt.userdetails d\n"
			+ "  ON u.userdetail_id=d.ID;",nativeQuery = true)
	List<Object[]> get();

	//void getByUserID(getDeatail id);
	 @Query(value="call cashbacknew(:from,:to,:CBpercent, :CBupto,:expirydays) ",nativeQuery= true)
	 int scheduledcashback(@Param("from") Date from,@Param("to") Date to,@Param("CBpercent") double CBpercent, @Param("CBupto") double CBupto, @Param("expirydays")int expirydays );
	
	@Query(value="select * from tt.wallets where user_id_id=:id",nativeQuery= true)
	List<Object[]> findbyid(int id);
	
	@Query(value="select * from tt.wallets ",nativeQuery= true)
	List<Object[]> findALL();
	
	@Query(value="select * from tt.wallets where AMOUNT_STATUS=:amounttype",nativeQuery= true)
	List<Object[]> findbyamounttype(String amounttype);
	
	
	
}
