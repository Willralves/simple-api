package br.com.william.simple_api.base.builder;

import br.com.william.simple_api.base.dto.ApiResponse;
import br.com.william.simple_api.base.dto.BaseResultDto;
import org.springframework.http.HttpStatus;

public class ResponseSuccessBuilder<T> {

    public static <T> ApiResponse<T> build(T data, HttpStatus httpStatus, String message) {

        BaseResultDto result = new BaseResultDto(httpStatus.value(), message != null ? message : httpStatus.getReasonPhrase());
        return new ApiResponse<>(data, null, result);
    }


}
