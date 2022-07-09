package sv.com.unicomer.jamaica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.unicomer.jamaica.model.Salesperson;

public interface ISalespersonRepository extends JpaRepository<Salesperson, Integer> {

}
