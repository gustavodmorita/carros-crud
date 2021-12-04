package br.com.gustavodm.carroscrud.repository;

import br.com.gustavodm.carroscrud.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
