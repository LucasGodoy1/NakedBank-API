package lucasgodoy1.com.github.nakedapi.repository;

import lucasgodoy1.com.github.nakedapi.entity.Cliente;
import lucasgodoy1.com.github.nakedapi.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
