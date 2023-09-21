package com.example.kakao.product.option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.PreDestroy;
import java.util.List;

public interface OptionJPARepository extends JpaRepository<Option, Integer> {

    List<Option> findByProductId(int id);

    @Query("select o from Option o where o.product.id=:id")
    List<Option> findByProductId(@Param("id") Integer id);
}
