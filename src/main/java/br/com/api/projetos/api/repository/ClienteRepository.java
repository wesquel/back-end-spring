package br.com.api.projetos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.projetos.api.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    

}
