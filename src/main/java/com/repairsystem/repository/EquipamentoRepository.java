package com.repairsystem.repository;

import com.repairsystem.domain.entity.Equipamento;
import com.repairsystem.domain.enums.CategoriaEquipamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    Page<Equipamento> findByCategoria(CategoriaEquipamento categoria, Pageable pageable);

    Page<Equipamento> findByTipo(String tipo, Pageable pageable);

    Page<Equipamento> findByFabricanteId(Long fabricanteId, Pageable pageable);

    List<Equipamento> findByModeloContainingIgnoreCase(String modelo);

    @Query("SELECT e FROM Equipamento e WHERE LOWER(e.modelo) LIKE LOWER(CONCAT('%', :modelo, '%')) "
            + "AND e.categoria = :categoria AND e.fabricante.id = :fabricanteId")
    List<Equipamento> buscarEquipamentoPorFiltros(@Param("modelo") String modelo,
            @Param("categoria") CategoriaEquipamento categoria, @Param("fabricanteId") Long fabricanteId);

    @Query("SELECT e FROM Equipamento e JOIN e.dicas d WHERE d.id = :dicaId")
    List<Equipamento> findByDicasId(@Param("dicaId") Long dicaId);

    @Query("SELECT COUNT(e) > 0 FROM Equipamento e WHERE e.modelo = :modelo AND e.fabricante.id = :fabricanteId")
    boolean existeEquipamentoByModeloAndFabricante(@Param("modelo") String modelo,
            @Param("fabricanteId") Long fabricanteId);
}
