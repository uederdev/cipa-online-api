package br.com.ueder.cipa_online.cargos;

import java.util.List;
import java.util.Optional;

public interface ICargoService {

    List<DadosCargo> listAll();

    Optional<DadosCargo> listById(String id);

    Optional<DadosCargo> listByCodigo(String codigo);

    Optional<Cargo> save(DadosCargo dadosCargo);

    Cargo deleteById(String id);
}
