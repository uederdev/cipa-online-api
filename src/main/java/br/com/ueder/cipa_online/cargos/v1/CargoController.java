package br.com.ueder.cipa_online.cargos.v1;

import br.com.ueder.cipa_online.cargos.Cargo;
import br.com.ueder.cipa_online.cargos.DadosCargo;
import br.com.ueder.cipa_online.cargos.ICargoService;
import br.com.ueder.cipa_online.exceptions.ErroApi;
import br.com.ueder.cipa_online.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cargos")
public class CargoController {

    @Autowired
    private ICargoService service;

    @GetMapping
    public ResponseEntity<List<DadosCargo>> getCargos(){
        List<DadosCargo> cargos = service.listAll();
        if (cargos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(cargos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosCargo> getCargosById(@PathVariable String id){
        return ResponseEntity.ok(service.listById(id).get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody DadosCargo dadosCargo){
        if (service.listByCodigo(dadosCargo.codigo()).isPresent()){
            return ResponseEntity.badRequest().body(new ErroApi("Registro já encontrado com o código: " + dadosCargo.codigo()));
        }
        Optional<Cargo> newCargo = service.save(dadosCargo);
        return ResponseEntity.created(Util.getUri("/v1/cargos/{id}", newCargo.get().getId()))
                .body(newCargo.get().toDto());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody DadosCargo dadosCargo){
        Cargo cargo = new Cargo(service.listById(id).get());
        cargo.setDescricao(dadosCargo.descricao());
        return ResponseEntity.ok(service.save(cargo.toDto())
                                        .get().toDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        service.listById(id);
        service.deleteById(id);
        return ResponseEntity.ok(new ErroApi("Registro excluido com sucesso."));
    }
}
