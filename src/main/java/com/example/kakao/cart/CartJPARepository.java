package com.example.kakao.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {


    List<Cart> findAllByUserId(int userId);
    void deleteByUserId(int userId);
}
