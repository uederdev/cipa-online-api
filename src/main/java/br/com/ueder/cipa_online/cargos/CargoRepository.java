package br.com.ueder.cipa_online.cargos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String> {

    @Query("select c from Cargo c where c.eliminado = false order by c.codigo")
    List<Cargo> findAll();
    Optional<Cargo> findByCodigo(String codigo);

}
