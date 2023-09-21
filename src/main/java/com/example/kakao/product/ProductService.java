package com.example.kakao.product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.kakao._core.errors.exception.Exception404;
import com.example.kakao.product.option.Option;
import com.example.kakao.product.option.OptionJPARepository;
import com.example.kakao.user.User;
import com.example.kakao.user.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;
    private final OptionJPARepository optionJPARepository;




    // (기능1) 상품 목록보기
    public List<ProductResponse.FindAllDTO> findAll(int page) {

        List<Product> productPS = productJPARepository.findAll();

        List<ProductResponse.FindAllDTO> findAllDTOS = productPS.stream()
                .map(t -> new ProductResponse.FindAllDTO(t))
                .collect(Collectors.toList());

        return findAllDTOS;
    }


    // (기능2) 상품 상세보기
    public ProductResponse.FindByIdDTO findById(int id) {
        return null;
    }


    //양방향매핑
    public ProductResponse.FindByIdDTOV2 findByIdV2(int id) {
        Product productPS = productJPARepository.findById(id)
                .orElseThrow(()-> new Exception404("해당 id의 상품을 찾을수 없습니다.: "+id));

        ProductResponse.FindByIdDTOV2 responseDTO = new ProductResponse.FindByIdDTOV2(productPS);

        return responseDTO;
    }


    //상품조회+옵션조회
    public ProductResponse.FindByIdDTOV1 findByIdV1(int id) { //DB에서 조회한자료는 뒤에 PS붙임

        Product productPS = productJPARepository.findById(id)
                .orElseThrow(()-> new Exception404("해당 id의 상품을 찾을수없습니다.: "+ id));

        List<Option> optionPS = optionJPARepository.findByProductId(id);

        return new ProductResponse.FindByIdDTOV1(productPS, optionPS);
    }


}
