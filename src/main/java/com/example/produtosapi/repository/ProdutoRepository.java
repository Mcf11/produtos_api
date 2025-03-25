package com.example.produtosapi.repository;

import com.example.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    // Implementando metodo findbyproduct_name que não existia nos métodos genéricos
    List<Produto> findByName(String name);
}
