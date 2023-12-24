package dev.orewaee.mosstures.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.orewaee.mosstures.dto.ErrorDto;

@ControllerAdvice
public class TextureNotFoundExceptionHandler {
    @ExceptionHandler(value = TextureNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTextureNotFoundException(TextureNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
