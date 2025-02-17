package br.com.william.simple_api.mapper;

import br.com.william.simple_api.dto.CadastroProdutoRequest;
import br.com.william.simple_api.dto.ProdutoResponse;
import br.com.william.simple_api.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(CadastroProdutoRequest cadastroProdutoRequest) {
        return Produto.builder()
            .nome(cadastroProdutoRequest.getNome())
            .descricao(cadastroProdutoRequest.getDescricao())
            .preco(cadastroProdutoRequest.getPreco())
            .build();
    }

    public ProdutoResponse toResponse(Produto produto) {
        return ProdutoResponse.builder()
            .id(produto.getId())
            .nome(produto.getNome())
            .descricao(produto.getDescricao())
            .preco(produto.getPreco())
            .criadoEm(produto.getCriadoEm())
            .atualizadoEm(produto.getAtualizadoEm())
            .build();
    }
}
