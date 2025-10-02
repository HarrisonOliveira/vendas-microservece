package com.vendas.repository;

import com.vendas.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String> {
    Produto findByEan(String ean);
}
