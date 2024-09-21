package lucasgodoy1.com.github.nakedapi.repository;

import lucasgodoy1.com.github.nakedapi.entity.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Extrato, Long> {

}
