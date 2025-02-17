package br.com.william.simple_api.controller;

import br.com.william.simple_api.dto.CadastroProdutoRequest;
import br.com.william.simple_api.dto.ProdutoResponse;
import br.com.william.simple_api.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@Valid @RequestBody CadastroProdutoRequest cadastroProdutoRequest) {

        ProdutoResponse response = produtoService.cadastrarProduto(cadastroProdutoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
