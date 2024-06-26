package com.example.dtomarketproject.order;

import com.example.dtomarketproject.product.Product;
import com.example.dtomarketproject.user.User;
import lombok.Data;

public class OrderRequest {

    @Data
    public static class PaymentDTO{
        private String payment;
    }


    @Data
    public static class StatusDTO{
        private String status;
    }

    @Data
    public static class UpdateDTO{
        // 주문수량
        private Integer orderQty;
    }

    @Data
    public static class SaveDTO {
        // 주문수량
        private Integer orderQty;

        // DTO에서 엔티티로 변환하는 메서드

        public Order toEntity(Product product, User user) {
            return Order.builder()
                    .orderQty(orderQty)
                    .product(product)
                    .user(user)
                    .build();
        }

    }

}
