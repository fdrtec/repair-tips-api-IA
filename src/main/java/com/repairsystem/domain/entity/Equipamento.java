package com.repairsystem.domain.entity;

import com.repairsystem.domain.enums.CategoriaEquipamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipamento", indexes = { @Index(name = "idx_equipamento_modelo", columnList = "modelo"),
        @Index(name = "idx_equipamento_categoria", columnList = "categoria"),
        @Index(name = "idx_equipamento_tipo", columnList = "tipo"),
        @Index(name = "idx_equipamento_fabricante_id", columnList = "fabricante_id") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = { "dicas", "pecas", "fabricante" })
@ToString(exclude = { "dicas", "pecas", "fabricante" })
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Modelo do equipamento é obrigatório")
    @Size(min = 3, max = 150, message = "Modelo deve ter entre 3 e 150 caracteres")
    @Column(nullable = false, length = 150)
    private String modelo;

    @NotNull(message = "Categoria do equipamento é obrigatória")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private CategoriaEquipamento categoria;

    @NotBlank(message = "Tipo do equipamento é obrigatório")
    @Size(min = 3, max = 100, message = "Tipo deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String tipo;

    @NotNull(message = "Fabricante é obrigatório")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fabricante_id", nullable = false)
    private Fabricante fabricante;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "equipamento_dica", joinColumns = @JoinColumn(name = "equipamento_id"), inverseJoinColumns = @JoinColumn(name = "dica_id"))
    @Builder.Default
    private Set<Dica> dicas = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "equipamento_peca", joinColumns = @JoinColumn(name = "equipamento_id"), inverseJoinColumns = @JoinColumn(name = "peca_id"))
    @Builder.Default
    private Set<Peca> pecas = new HashSet<>();

    public void addDica(Dica dica) {
        dicas.add(dica);
        dica.getEquipamentos().add(this);
    }

    public void removeDica(Dica dica) {
        dicas.remove(dica);
        dica.getEquipamentos().remove(this);
    }

    public void addPeca(Peca peca) {
        pecas.add(peca);
        peca.getEquipamentos().add(this);
    }

    public void removePeca(Peca peca) {
        pecas.remove(peca);
        peca.getEquipamentos().remove(this);
    }
}
