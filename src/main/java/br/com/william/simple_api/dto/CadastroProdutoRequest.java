package br.com.william.simple_api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroProdutoRequest {

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @Size(min = 10, max = 100,message = "O campo descrição deve ter no mínimo 10 e no máximo 100 caracteres.")
    private String descricao;

    @DecimalMin(value = "0.01", message = "O campo preço deve ser maior que zero.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal preco;
}
