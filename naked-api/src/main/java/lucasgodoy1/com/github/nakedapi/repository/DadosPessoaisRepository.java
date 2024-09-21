package lucasgodoy1.com.github.nakedapi.repository;

import lucasgodoy1.com.github.nakedapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosPessoaisRepository  extends JpaRepository<Cliente, Long> {

}
