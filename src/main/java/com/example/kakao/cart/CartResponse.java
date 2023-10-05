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

    // 1. List<Cart> 값을 스트림에 던진다
    // 2. C4, C5, C6 을 P1, P1, P2 로 바꾼다
    // 3. P1, P1, P2 를 Distinct 해서 중복을 제거한다.
    // 4. P1, P2 + List<Cart> 를 이용해서 DTO(P1, List<Cart>) 를 넣는다
    // 5. DTO(P1, List<Cart>) 에서 List<Cart> 중 P1 을 가지고 있는거만 filter 한다.

    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalPrice;
        private List<ProductDTO> products;

//        public FindAllByUserDTO(List<Cart> cartList) { //카트리스트를 조회해왔으니 그거 넣자.
//            this.totalPrice = cartList.stream().mapToInt(c->c.getPrice()).sum();
//            this.products = cartList.stream().mapToInt(cart-> cart.getPrice(cart)).sum();
//        }

        public FindAllByUserDTO(List<Cart> cartList) {
            this.totalPrice = cartList.stream().mapToInt(cart -> cart.getPrice()).sum();
            this.products = cartList.stream()
                    .map(new Function<Cart, Product>() {
                        @Override
                        public Product apply(Cart cart) {
                            return cart.getOption().getProduct();
                        }
                    }).distinct()
                    .map(product -> new ProductDTO(product, cartList))
                    .collect(Collectors.toList());
        }

        @Getter @Setter
        class ProductDTO {
            private String productName;
            private List<CartDTO> carts;



            public ProductDTO(Product product, List<Cart> carts) {
                this.productName = product.getProductName();
                this.carts = carts.stream()
                        .filter(cart -> cart.getOption().getProduct().getId() == product.getId())
                        .map(cart -> new CartDTO(cart))
                        .collect(Collectors.toList());
            }

            @Getter @Setter
            class CartDTO {
                private String cartOptionName;
                private Integer cartQuantity;
                private Integer cartPrice;

                public CartDTO(Cart cart) {
                    this.cartOptionName = cart.getOption().getOptionName();
                    this.cartQuantity = cart.getQuantity();
                    this.cartPrice = cart.getPrice();
                }


            }
        }
    }
}



