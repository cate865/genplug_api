package com.genplug.genplug.classes;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "professionals")
public class Professional {
    @Id
    @Column(name = "prof_email", unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Please provide your first name")
    private String name;


    @Column(name = "password")
    private String password;


    @Column(name = "logged_in")
    private Boolean loggedIn;

    @Column(name = "experience_years")
    private int yearsOfExperience;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @OneToMany(mappedBy = "professionalAcc")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "owner")
    private List<Blog> blogs;

    public Professional() {
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


}
