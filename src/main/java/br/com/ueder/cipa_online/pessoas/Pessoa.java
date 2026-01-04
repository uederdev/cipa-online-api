package br.com.ueder.cipa_online.pessoas;

import br.com.ueder.cipa_online.cargos.Cargo;
import br.com.ueder.cipa_online.setores.Setor;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private String id;
    private Integer numero;
    private String nome;
    private String apelido;
    private String matricula;
    private String pathFoto;
    private Cargo cargo;
    private Setor setor;
    private Boolean ativo;

}
