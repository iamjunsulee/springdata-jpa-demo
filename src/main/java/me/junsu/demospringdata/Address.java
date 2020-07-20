package me.junsu.demospringdata;

import javax.persistence.Embeddable;

@Embeddable
/* composite value type */
public class Address {
    private String city;
    private String state;
    private String street;
    private String zipCode;
}
