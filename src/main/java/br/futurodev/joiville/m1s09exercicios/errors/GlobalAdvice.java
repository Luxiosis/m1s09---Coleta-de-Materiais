package br.futurodev.joiville.m1s09exercicios.errors;

import br.futurodev.joiville.m1s09exercicios.dtos.erros.ErrorResponseDto;
import br.futurodev.joiville.m1s09exercicios.errors.exeptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDto> exception(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> exception(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getSimpleName()
        ));
    }

}
