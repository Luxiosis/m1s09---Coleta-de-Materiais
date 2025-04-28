package br.futurodev.joiville.m1s09exercicios.dtos.erros;

public record ErrorResponseDto(
        String code,
        String message,
        String cause,
        String exceptionClassName
) {
}
