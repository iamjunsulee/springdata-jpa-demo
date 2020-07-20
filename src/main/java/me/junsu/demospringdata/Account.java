package me.junsu.demospringdata;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String sample;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column = @Column(name="COMPANY_CITY")),
            @AttributeOverride(name="state", column = @Column(name = "COMPANY_STATE")),
            @AttributeOverride(name="street", column = @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name="zipCode", column = @Column(name = "COMPANY_ZIP_CODE")),
    })
    private Address officeAddress;

    @Transient
    private String sample2;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
