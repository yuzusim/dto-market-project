package com.example.dtomarketproject.order;

import com.example.dtomarketproject.product.Product;
import com.example.dtomarketproject.product.ProductRepository;
import com.example.dtomarketproject.user.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final EntityManager em;

    //
    @Transactional
    public Order updateById(int id, OrderRequest.UpdateDTO reqDTO) {
        return orderRepo.updateById(id, reqDTO);
    }

    //상세보기
    public OrderResponse.OrderDTO getOrderDetail(Integer userId, Integer productId) {
        //Product product = productRepo.findById(productId); //상품id조회
        Order order = orderRepo.findByProductIdAndUserId(productId, userId); //해당 제품과 사용자에 해당하는 주문찾음
        return new OrderResponse.OrderDTO(order);
    }

    //상세보기
    public OrderResponse.DetailDTO findById(int id) {
        Order order = orderRepo.findById(id);
        return new OrderResponse.DetailDTO(order);
    }


    //구매하기
    @Transactional
    public OrderResponse.SaveDTO save(OrderRequest.SaveDTO reqDTO, int id, User user) {
        Product product = productRepo.findById(id);
        Order order = orderRepo.save(reqDTO.toEntity(product, user));
        return new OrderResponse.SaveDTO(order);
    }

    //주문 폼 order-form
    public List<OrderResponse.OrderDTO> findByOrderAndUserId(int id) {
        List<Order> saveList = orderRepo.findByOrderAndUserId(id);
        return saveList.stream().map(OrderResponse.OrderDTO::new).toList();
    }

    //구매목록 메서드 order/list
    public List<OrderResponse.ListDTO> findAll() {
        List<Order> orderList = orderRepo.findAll();
        return orderList.stream().map(OrderResponse.ListDTO::new).toList();
    }

}
