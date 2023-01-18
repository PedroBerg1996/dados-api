package com.dados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dados.entities.Dados;

@Repository
public interface DadosRepository extends JpaRepository<Dados, Long> {

}
