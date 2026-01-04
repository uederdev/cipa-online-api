package br.com.ueder.cipa_online.cargos;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cargos")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 6)
    private String codigo;
    @Column(nullable = false, length = 80)
    private String descricao;
    private boolean eliminado = false;

    public Cargo(){

    }

    public Cargo(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Cargo(DadosCargo dadosCargo) {
        this.id = dadosCargo.id();
        this.codigo = dadosCargo.codigo();
        this.descricao = dadosCargo.descricao();
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void eliminar(){
        this.eliminado = true;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public DadosCargo toDto() {
        return new DadosCargo(this.id, this.codigo, this.descricao);
    }
}
