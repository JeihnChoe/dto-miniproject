package com.example.kakao.cart;

import com.example.kakao.product.ProductResponse;
import com.example.kakao.product.option.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public class CartResponse {

    // (기능3) 장바구니 조회
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {

        private Integer productId;
        private String productName;
        private List<CartDTO> carts;


        public FindAllByUserDTO(List<Cart> carts) {

            this.productId = carts
            this.productName = carts.getOption().getProduct().getProductName();
            this.carts = carts.stream().

        }

        @Getter
        @Setter
        public class CartDTOS{

            private List<Cart> cartDTOS;


            public CartDTOS(List<Cart> cartDTOS) {
                this.cartDTOS = cartDTOS;
            }
        }

        @ToString
        @Getter
        @Setter
        public class CartDTO{
            private Integer cartId;
            private List<OptionDTO> options;
            private Integer cartQuantity;
            private Integer cartPrice;

            public CartDTO(Cart cart) {
                this.cartId = cart.getId();
                this.options = getOptions().stream().map(t->new OptionDTO(t)).collect(Collectors.toList());
                this.cartQuantity = cart.getQuantity();
                this.cartPrice = cart.getPrice();
            }

            @ToString
            @Getter
            @Setter
            public class OptionDTO{
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
}
