package com.example.kakao.product;

import com.example.kakao.product.option.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {

    // (기능1) 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {
        private Integer productId;
        private String image;
        private String productName;
        private Integer productPrice;

        public FindAllDTO(Product product) {
            this.productId = product.getId();
            this.image = product.getImage();
            this.productName = product.getProductName();
            this.productPrice = product.getPrice();
        }
    }

    // (기능2) 상품 상세보기
    @Getter
    @Setter
    public static class FindByIdDTO {
        private Integer productId;
        private String productName;
        private String image;
        private Integer price;
        private Integer starCount;
        private List<Option> options = new ArrayList<>();

        public FindByIdDTO(Product product) {
            this.productId = productId;
            this.productName = productName;
            this.image = image;
            this.price = price;
            this.starCount = starCount;
            this.options = product.getOptions().stream().map(t->new OptionDTO(t)).collect(Collectors.toList());
        }

        @Getter
        @Setter
        public class OptionDTO{
            private Integer optionId;
            private String optionName;
            private Integer optionPrice;

            public List<OptionDTO optionDTO>(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getPrice();

            }
        }
    }
}