package lucasgodoy1.com.github.nakedapi.controller;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Extrato;
import lucasgodoy1.com.github.nakedapi.service.ExtratoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/nakedBank/")
public class ExtratoWebController {
    private final ExtratoService extratoService;

    @GetMapping("meusextratos={id}")
    public ResponseEntity<List<Extrato>> meusExtratos(@PathVariable String id) {

        var extratosEncontrados = extratoService.meusExtratos(id);

        if (extratosEncontrados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(extratosEncontrados);
    }


}
