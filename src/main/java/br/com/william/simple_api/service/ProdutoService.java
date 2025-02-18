package br.com.william.simple_api.service;

import br.com.william.simple_api.base.builder.ResponseSuccessBuilder;
import br.com.william.simple_api.base.dto.ApiResponse;
import br.com.william.simple_api.dto.CadastroProdutoRequest;
import br.com.william.simple_api.dto.ProdutoResponse;
import br.com.william.simple_api.entity.Produto;
import br.com.william.simple_api.mapper.ProdutoMapper;
import br.com.william.simple_api.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoResponse cadastrarProduto(CadastroProdutoRequest cadastroProdutoRequest) {

        Produto produto = produtoMapper.toEntity(cadastroProdutoRequest);
        Produto produtoCadastrado = produtoRepository.save(produto);

        return produtoMapper.toResponse(produtoCadastrado);
    }

    public ProdutoResponse buscarProdutoPorId(Long id) {

        Produto response = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado"));

        return produtoMapper.toResponse(response);
    }
}
