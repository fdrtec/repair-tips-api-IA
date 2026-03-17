package com.repairsystem.domain.enums;

public enum CategoriaEquipamento {
    IMPRESSORA("Impressora"),
    SCANNER("Scanner"),
    COPIADORA("Copiadora"),
    MULTIFUNCIONAL("Multifuncional"),
    FAX("Fax"),
    PROJETOR("Projetor"),
    MONITOR("Monitor"),
    COMPUTADOR("Computador"),
    SERVIDOR("Servidor"),
    IMPRESSORA_3D("Impressora 3D"),
    OUTRO("Outro");

    private final String descricao;

    CategoriaEquipamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
