package com.repairsystem.repository;

import com.repairsystem.domain.entity.Peca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

    Optional<Peca> findByPartNumber(String partNumber);

    Page<Peca> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Peca> findByCategoria(String categoria, Pageable pageable);

    @Query("SELECT p FROM Peca p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%')) OR LOWER(p.partNumber) LIKE LOWER(CONCAT('%', :partNumber, '%'))")
    Page<Peca> buscarPecaPorNomeOuPartNumber(@Param("nome") String nome, @Param("partNumber") String partNumber, Pageable pageable);

    @Query("SELECT p FROM Peca p JOIN p.equipamentos e WHERE e.id = :equipamentoId")
    Page<Peca> findByEquipamentoId(@Param("equipamentoId") Long equipamentoId, Pageable pageable);

    boolean existsByPartNumber(String partNumber);

    @Query("SELECT COUNT(p) > 0 FROM Peca p WHERE LOWER(p.partNumber) = LOWER(:partNumber)")
    boolean existsPartNumberIgnoreCase(@Param("partNumber") String partNumber);
}
