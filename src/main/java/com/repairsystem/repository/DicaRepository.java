package com.repairsystem.repository;

import com.repairsystem.domain.entity.Dica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DicaRepository extends JpaRepository<Dica, Long> {

    Page<Dica> findByAtivoTrue(Pageable pageable);

    List<Dica> findByAtivoTrueOrderByDataCriacaoDesc();

    @Query("SELECT d FROM Dica d WHERE d.ativo = true AND LOWER(d.problemDescricao) LIKE LOWER(CONCAT('%', :problema, '%'))")
    List<Dica> findByProblemaDescricaoContainingIgnoreCase(@Param("problema") String problema);

    @Query("SELECT d FROM Dica d JOIN d.equipamentos e WHERE e.id = :equipamentoId AND d.ativo = true")
    List<Dica> findByEquipamentoIdAndAtivoTrue(@Param("equipamentoId") Long equipamentoId);

    @Query("SELECT d FROM Dica d JOIN d.pecas p WHERE p.id = :pecaId AND d.ativo = true")
    List<Dica> findByPecaIdAndAtivoTrue(@Param("pecaId") Long pecaId);

    @Query("SELECT d FROM Dica d JOIN d.equipamentos e JOIN e.fabricante f "
            + "WHERE f.sigla = :siglFabricante AND d.ativo = true")
    List<Dica> findByFabricanteSiglaAndAtivoTrue(@Param("siglFabricante") String siglFabricante);

    @Query("SELECT d FROM Dica d WHERE d.ativo = false")
    Page<Dica> findByAtivoFalse(Pageable pageable);
}
