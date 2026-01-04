package br.com.ueder.cipa_online.pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {

    @Autowired
    private static IPessoaService service;

    @GetMapping
    public ResponseEntity<List<DadosPessoas>> listAll(){
        List<DadosPessoas> pessoasMock = service.getAllDadosPessoa();
        return pessoasMock.isEmpty() ? ResponseEntity.noContent().build()
                                     : ResponseEntity.ok(pessoasMock);
    }

}
