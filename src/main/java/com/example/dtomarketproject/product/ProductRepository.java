package com.example.dtomarketproject.product;

import com.example.dtomarketproject._core.common.ImgSaveUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepository {
    private final EntityManager em;

//    //상품 ID를 가진 모든 주문을 찾아 삭제하는 쿼리를 실행
//    public void deleteProductById(int productId) {
//        Query query = em.createQuery("delete from Order o where o.product.id = :productId");
//        query.setParameter("productId", productId);
//        query.executeUpdate();
//    }

    // 상품을 참조하는 모든 주문 삭제
    public void deleteById(int id) {
        Query query =
                em.createQuery("delete from Product p where p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    //상품 수정하기
    public Product updateById(int id, ProductRequest.UpdateDTO reqDTO) {
        Product product = em.find(Product.class, id);
        product.setName(reqDTO.getName());
        product.setPrice(reqDTO.getPrice());
        product.setQty(reqDTO.getQty());
        product.setImg(ImgSaveUtil.save(reqDTO.getImg()));
        return product;
    }

    //상품 상세보기
    public Product findById(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    //상품 등록하기
    @Transactional
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    //상품 목록보기
    public List<Product> findAll() {
        Query query =
                em.createQuery("select p from Product p order by p.id desc", Product.class);
        return query.getResultList();
    }
}
