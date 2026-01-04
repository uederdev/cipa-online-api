package br.com.ueder.cipa_online.setores;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "setores")
public class Setor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 6)
    private String codigo;
    @Column(nullable = false, length = 80)
    private String descricao;

    public Setor() {
    }

    public Setor(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
