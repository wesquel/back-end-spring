package br.com.api.projetos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.projetos.api.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
