package br.dev.diego.springmongodb.entities;

import lombok.Data;

@Data
public class Address {

    private String country;
    private String postCode;
    private String city;

}
