package com.repairsystem.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dica", indexes = {
    @Index(name = "idx_dica_ativo", columnList = "ativo"),
    @Index(name = "idx_dica_data_criacao", columnList = "data_criacao")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"equipamentos", "pecas"})
@ToString(exclude = {"equipamentos", "pecas"})
public class Dica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descrição do problema é obrigatória")
    @Size(min = 50, max = 1000, message = "Descrição do problema deve ter entre 50 e 1000 caracteres")
    @Column(nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String problemDescricao;

    @NotBlank(message = "Descrição da solução é obrigatória")
    @Size(min = 50, max = 2000, message = "Descrição da solução deve ter entre 50 e 2000 caracteres")
    @Column(nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String solucaoDescricao;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

    @Column(nullable = false)
    private Boolean ativo = true;

    @ManyToMany(mappedBy = "dicas", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Builder.Default
    private Set<Equipamento> equipamentos = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "dica_peca",
        joinColumns = @JoinColumn(name = "dica_id"),
        inverseJoinColumns = @JoinColumn(name = "peca_id")
    )
    @Builder.Default
    private Set<Peca> pecas = new HashSet<>();

    public void addEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
        equipamento.getDicas().add(this);
    }

    public void removeEquipamento(Equipamento equipamento) {
        equipamentos.remove(equipamento);
        equipamento.getDicas().remove(this);
    }

    public void addPeca(Peca peca) {
        pecas.add(peca);
        peca.getDicas().add(this);
    }

    public void removePeca(Peca peca) {
        pecas.remove(peca);
        peca.getDicas().remove(this);
    }
}
