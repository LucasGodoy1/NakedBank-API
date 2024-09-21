package lucasgodoy1.com.github.nakedapi.repository;


import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
