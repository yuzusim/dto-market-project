package com.example.dtomarketproject.order;

import com.example.dtomarketproject.product.Product;
import com.example.dtomarketproject.user.User;
import lombok.Data;

public class OrderResponse {

    //주문 폼
    //상세보기
    @Data
    public static class OrderDTO {
        private Integer id;
        private User user; // 사용자 ID만 포함
        private Product product; // 상품 ID만 포함
        private String img;
        private String name;
        private Integer price;
        private Integer qty;
        private String payment;
        private Integer orderQty;
        private String status;
        private String address;

        public OrderDTO(Order order) {
            this.id = order.getId();
            this.user = order.getUser();
            this.product = order.getProduct();
            this.img = order.getProduct().getImg();
            this.name = order.getProduct().getName();
            this.price = order.getProduct().getPrice();
            this.qty = order.getProduct().getQty();
            this.payment = order.getPayment();
            this.orderQty = order.getOrderQty();
            this.status = order.getStatus();
            this.address = order.getUser().getAddress();
        }
    }

    //상세보기
    @Data
    public static class DetailDTO{
        private Integer orderQty;

        public DetailDTO(Order Order) {
            this.orderQty = Order.getOrderQty();
        }
    }

    //업데이트
    @Data
    public static class UpdateDTO{
        private Integer orderQty;

        public UpdateDTO(Order Order) {
            this.orderQty = Order.getOrderQty();
        }
    }


    //구매
    @Data
    public static class SaveDTO {
        private Integer id;
        private User user; // 사용자 ID만 포함
        private Product product; // 상품 ID만 포함
        private String img;
        private String name;
        private Integer price;
        private Integer orderQty;
        private String address;

        public SaveDTO(Order order) {
            this.id = order.getId();
            this.user = order.getUser();
            this.product = order.getProduct();
            this.img = order.getProduct().getImg();
            this.name = order.getProduct().getName();
            this.price = order.getProduct().getPrice();
            this.orderQty = order.getOrderQty();
            this.address = order.getUser().getAddress();

        }
    }

    //주문 목록보기
    @Data
    public static class ListDTO {
        private Integer id;
        private User user; // 사용자 ID만 포함
        private Product product; // 상품 ID만 포함
        private String payment;
        private Integer orderQty;
        private String status;

        public ListDTO(Order order) {
            this.id = order.getId();
            this.user = order.getUser();
            this.product =order.getProduct();
            this.payment = order.getPayment();
            this.orderQty = order.getOrderQty();
            this.status = order.getStatus();
        }
    }

}