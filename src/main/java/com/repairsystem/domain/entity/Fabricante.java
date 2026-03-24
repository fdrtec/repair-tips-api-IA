package com.repairsystem.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fabricante", indexes = { @Index(name = "idx_fabricante_nome", columnList = "nome"),
        @Index(name = "idx_fabricante_sigla", columnList = "sigla") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "equipamentos")
@ToString(exclude = "equipamentos")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do fabricante é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @NotBlank(message = "Sigla do fabricante é obrigatória")
    @Size(min = 2, max = 5, message = "Sigla deve ter entre 2 e 5 caracteres")
    @Column(nullable = false, unique = true, length = 5)
    private String sigla;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Equipamento> equipamentos = new HashSet<>();

    public void addEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
        equipamento.setFabricante(this);
    }

    public void removeEquipamento(Equipamento equipamento) {
        equipamentos.remove(equipamento);
        equipamento.setFabricante(null);
    }
}
