package com.shophub.store_app.repositories;

import com.shophub.store_app.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

//    @Query("select P" +
//     "from Product P" +
//    "where P.category.subcategory.surname=:categorySyrName")
//    List<Product> blablabla(@Param("categorySurName") String categorySyrName);

    List<Product> findByName(String name);

    Page<Product> findAllByNameAndCategory_id(String name, Long categoryId, Pageable pageable);
}
