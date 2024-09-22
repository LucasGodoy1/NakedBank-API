package lucasgodoy1.com.github.nakedapi.repository;

import lucasgodoy1.com.github.nakedapi.entity.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Long> {
    List<Extrato> findByContaID_NumeroDaConta(String contaId);
}
