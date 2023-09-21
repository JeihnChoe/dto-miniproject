package com.example.kakao.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakao._core.utils.ApiUtils;
import com.example.kakao._core.vo.MyPath;
import com.example.kakao.product.ProductResponse.FindAllDTO;
import com.example.kakao.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService; // 자바에서 final 변수는 반드시 초기화되어야함.
                                                //IOC와 DI 의 기본 원리는 Autowired가 아니라 생성자를 만드는거임


//    public ProductRestController(ProductService productService) {
//        this.productService = productService;
//    }
                                                //원래는 이렇게 생성자 주입을 해줘야함
                                                //따라서 28~30번 라인과 같이 생성자를 주입해서 productService를 초기화해준다.
                                                //생성자 주입이 되는 원리는 뭐야? IOC에 떠있기 때문
                                                //@RequiredArgsConstructor + final 선언 조합이면 @Autowired 를 대신할수있따.

    // (기능1) 상품 목록보기
    @GetMapping("/products")
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page) {

        List<FindAllDTO> responseDTO = productService.findAll(page);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));

    }

    // (기능2) 상품 상세보기

    //양방향매핑
    @GetMapping("/products/{id}/v2")
    public ResponseEntity<?> findByIdV2(@PathVariable int id) {
        ProductResponse.FindByIdDTOV2 responseDTO = productService.findByIdV2(id);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }



    //2번 조회하기
    @GetMapping("/products/{id}/v1")
    public ResponseEntity<?> findById(@PathVariable int id) {
        ProductResponse.FindByIdDTOV1 responseDTO = productService.findByIdV1(id);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
}