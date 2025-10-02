package com.vendas.repository;

import com.vendas.entity.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVendaRepository extends MongoRepository<Venda, String> {
    Optional<Venda> findBycodigoVenda(String codigoVenda);
}
