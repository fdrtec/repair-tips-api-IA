package com.repairsystem.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "peca", indexes = { @Index(name = "idx_peca_part_number", columnList = "part_number"),
        @Index(name = "idx_peca_nome", columnList = "nome") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = { "equipamentos", "dicas" })
@ToString(exclude = { "equipamentos", "dicas" })
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da peça é obrigatório")
    @Size(min = 3, max = 200, message = "Nome deve ter entre 3 e 200 caracteres")
    @Column(nullable = false, length = 200)
    private String nome;

    @NotBlank(message = "Part Number é obrigatório")
    @Size(min = 3, max = 50, message = "Part Number deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Z0-9\\-]+$", message = "Part Number deve conter apenas letras maiúsculas, números e hífen")
    @Column(nullable = false, unique = true, length = 50)
    private String partNumber;

    @Size(max = 100, message = "Categoria deve ter no máximo 100 caracteres")
    @Column(length = 100)
    private String categoria;

    @ManyToMany(mappedBy = "pecas", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @Builder.Default
    private Set<Equipamento> equipamentos = new HashSet<>();

    @ManyToMany(mappedBy = "pecas", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @Builder.Default
    private Set<Dica> dicas = new HashSet<>();

    public void addEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
        equipamento.getPecas().add(this);
    }

    public void removeEquipamento(Equipamento equipamento) {
        equipamentos.remove(equipamento);
        equipamento.getPecas().remove(this);
    }

    public void addDica(Dica dica) {
        dicas.add(dica);
        dica.getPecas().add(this);
    }

    public void removeDica(Dica dica) {
        dicas.remove(dica);
        dica.getPecas().remove(this);
    }
}
