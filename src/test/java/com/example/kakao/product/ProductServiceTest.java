package com.example.kakao.product;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceTest {


    ProductJPARepository productJPARepository;

    // (기능1) 상품 목록보기
    @Test
    public List<ProductResponse.FindAllDTO> findAll(int page) {

        List<Product> productList = productJPARepository.findAll();

        List<ProductResponse.FindAllDTO> findAllDTOS = productList.stream()
                .map(t -> new ProductResponse.FindAllDTO(t))
                .collect(Collectors.toList());

        return findAllDTOS;
    }


    // (기능2) 상품 상세보기
    public ProductResponse.FindByIdDTO findById(int id) {
        return null;
    }
}