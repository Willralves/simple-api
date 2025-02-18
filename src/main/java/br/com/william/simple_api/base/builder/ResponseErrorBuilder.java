package br.com.william.simple_api.base.builder;

import br.com.william.simple_api.base.dto.ApiResponse;
import br.com.william.simple_api.base.dto.BaseErrorDto;
import br.com.william.simple_api.base.dto.BaseResultDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseErrorBuilder<T> {

    public static <T> ApiResponse<T> build(HttpStatus httpStatus, String message) {

        BaseResultDto result = new BaseResultDto(httpStatus.value(), message != null ? message : httpStatus.getReasonPhrase());
        return new ApiResponse<>(null, null, result);
    }

    public static <T> ApiResponse<T> build(HttpStatus httpStatus, String message, List<BaseErrorDto> errors) {

        BaseResultDto result = new BaseResultDto(httpStatus.value(), message != null ? message : httpStatus.getReasonPhrase());
        return new ApiResponse<>(null, errors, result);
    }

    public static <T> ApiResponse<T> build(HttpStatus httpStatus, List<BaseErrorDto> errors) {

        BaseResultDto result = new BaseResultDto(httpStatus.value(), httpStatus.getReasonPhrase());
        return new ApiResponse<>(null, errors, result);
    }

    //TODO verificar isso e ajustar esse metodo.
    public static <T> ApiResponse<T> addError(List<BaseErrorDto> errorList, String field, String message) {

        errorList.add(new BaseErrorDto(field, message));
        return new ApiResponse<>(null, errorList, new BaseResultDto(HttpStatus.BAD_REQUEST.value(), "Erro de validação."));
    }
}
