package com.repairsystem.repository;

import com.repairsystem.domain.entity.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    Optional<Fabricante> findByNome(String nome);

    Optional<Fabricante> findBySigla(String sigla);

    boolean existsByNome(String nome);

    boolean existsBySigla(String sigla);
}
