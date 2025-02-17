package br.com.william.simple_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
