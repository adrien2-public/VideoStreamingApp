package com.example.Accounts.Repository;




import com.example.Accounts.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    @Query("SELECT u FROM Account u WHERE u.email = :email")
    public Account getAccountByEmail(@Param("email") String email);


    @Query("SELECT u FROM Account u WHERE u.userName = :userName")
    public Account getAccountByUserName(@Param("userName") String username);






}
