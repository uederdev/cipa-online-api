package br.com.ueder.cipa_online.cargos;

import br.com.ueder.cipa_online.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoService implements ICargoService{

    @Autowired
    private CargoRepository repository;

    @Override
    public List<DadosCargo> listAll() {
        return repository.findAll()
                .stream()
                .map(x -> new DadosCargo(x.getId(),x.getCodigo(),x.getDescricao()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DadosCargo> listById(String id) {
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id)).toDto());
    }

    @Override
    public Optional<DadosCargo> listByCodigo(String codigo) {
        Cargo cargo = repository.findByCodigo(codigo).orElseThrow(() -> new ObjectNotFoundException(codigo));
        return Optional.ofNullable(cargo.toDto());
    }

    @Override
    @Transactional
    public Optional<Cargo> save(DadosCargo dadosCargo) {
        return Optional.of(repository.save(new Cargo(dadosCargo)));
    }

    @Override
    public Cargo deleteById(String id) {
        DadosCargo cargo = listById(id).get();
        Cargo oldCargo = new Cargo(cargo.codigo(), cargo.descricao());
        oldCargo.setId(cargo.id());
        oldCargo.eliminar();
        return repository.save(oldCargo);
    }
}
