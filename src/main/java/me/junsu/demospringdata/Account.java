package me.junsu.demospringdata;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    /*
    mappedBy 속성을 사용해서 속성의 값으로 연관관계의 주인을 설정
    연관관계의 주인은 mappedBy를 사용할 수 없다.
    아래에서 작성한 owner는 Study Entity에서 Account를 참조할 때 작성한 필드명
     */
    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

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

    /*
    연관관계 편의 메서드
    양방향일때, 양쪽에 다 넣어줘야한다.
    */
    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study){
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
