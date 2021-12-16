package com.genplug.genplug.classes;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="professions")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profession_id")
    private Long professionId;

    @Column(name = "profession_name")
    private String name;

    @OneToMany(mappedBy = "profession")
    private List<Blog> blogs;



    public Profession() {
    }


    public Profession(Long professionId, String name) {
        this.professionId = professionId;
        this.name = name;
    }

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
