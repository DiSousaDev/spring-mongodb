package br.dev.diego.springmongodb.controllers.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private Instant timeStamp;
    private String title;
    private Integer status;
    private String message;
    private String path;

}
