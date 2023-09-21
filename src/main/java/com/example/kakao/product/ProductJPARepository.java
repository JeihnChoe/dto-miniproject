package com.example.kakao.product;

import com.example.kakao.product.option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {

    @Query("select o from Option o where o.product.id=:id")
    List<Option> findByProductId(@Param("id") Integer id);    //collection은 null 이 아니라 빈배열이 있으므로 익셉션처리안해도됨
}
