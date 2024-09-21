package lucasgodoy1.com.github.nakedapi.controller;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.dto.CadastroDTO;
import lucasgodoy1.com.github.nakedapi.service.CadastroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/nakedBank/")
public class CadastroWebController {
    private final CadastroService cadastroService;

    @PostMapping("create")
    public ResponseEntity<CadastroDTO> cadastro(@RequestBody CadastroDTO cadastroDTO) {
        cadastroService.cadastroInicial(cadastroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroDTO);

    }

}



