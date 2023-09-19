package com.example.kakao.product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;

    // (기능1) 상품 목록보기
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
