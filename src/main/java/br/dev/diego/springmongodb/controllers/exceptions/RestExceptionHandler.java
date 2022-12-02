package br.dev.diego.springmongodb.controllers.exceptions;

import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMongoWriteException(MongoWriteException e, WebRequest req) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        return ResponseEntity.status(status).body(ErrorResponse.builder()
                .timeStamp(Instant.now())
                .title("MongoWriteException, please check the documentation.")
                .status(status.value())
                .message(e.getMessage())
                .path(req.getContextPath())
                .build());
    }

}
