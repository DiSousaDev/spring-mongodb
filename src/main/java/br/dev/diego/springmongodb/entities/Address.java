package br.dev.diego.springmongodb.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String country;
    private String postCode;
    private String city;

}
