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
    // 양방향매핑

    @Getter
    @Setter
    public static class FindByIdDTOV2 {

        private Integer productId;
        private String productName;
        private String productImage;
        private Integer productPrice;
        private Integer productStarCount;
        private List<OptionDTOV2> options;

        public FindByIdDTOV2(Product product) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.productImage = product.getImage();
            this.productPrice = product.getPrice();
            this.productStarCount = 4;
            this.options = product.getOptions().stream().map(t-> new OptionDTOV2(t)).collect(Collectors.toList());
        }

        @Getter
        @Setter
        public class OptionDTOV2 {
            private Integer optionId;
            private String optionName;
            private Integer optionPrice;

            public OptionDTOV2(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getPrice();
            }
        }
    }




    // (기능2) 상품 상세보기
    // product조회 + option조회
    @Getter
    @Setter
    public static class FindByIdDTOV1 {
        private Integer productId;
        private String productName;
        private String productImage;
        private Integer productPrice;
        private Integer productStarCount;
        private List<OptionDTOV1> options;


        public FindByIdDTOV1(Product product, List<Option> options) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.productImage = product.getImage();
            this.productPrice = product.getPrice();
            this.productStarCount = 4;
            this.options = options.stream()
                    .map(t->new OptionDTOV1(t))
                    .collect(Collectors.toList());

        }

        @Getter
        @Setter
        public class OptionDTOV1 {
            private Integer optionId;
            private String optionName;
            private Integer optionPrice;

            public OptionDTOV1(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getPrice();
            }
        }
    }

    @Getter
    @Setter
    public static class FindByIdDTO {
        private Integer productId;
        private String productName;
        private String productImage;
        private Integer productPrice;
        private Integer productStarCount;
        private List<OptionDTO> options;

        public FindByIdDTO(Product product, List<Option> options) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.productImage = product.getImage();
            this.productPrice = product.getPrice();
            this.productStarCount = 4;
            this.options = options.stream()
                    .map(o -> new OptionDTO(o))
                    .collect(Collectors.toList());
        }


        @Getter
        @Setter
        public class OptionDTO {
            private Integer optionId;
            private String optionName;
            private Integer optionPrice;

            public OptionDTO(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getPrice();
            }
        }
    }


}