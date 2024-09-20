package lucasgodoy1.com.github.nakedapi.repository;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContaRepository extends JpaRepository<Conta, Long> {

}
