// Authors: Liplan Lekipising and catherine Muthoni
package com.genplug.genplug.classes;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name="client_email", unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Please provide your first name")
    private String name;


    @Column(name = "password")
    private String password;


    @Column(name="logged_in")
    private Boolean loggedIn;

    @OneToMany(mappedBy = "clientAcc")
    private List<Appointment> appointments;

//    @OneToMany(mappedBy = "client_email")
//    private List<Appointment> appointments;


//    @OneToOne
//    @JoinColumn(name="profession_id")
//    private Profession profession;

    public Client() {
    }



    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
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

//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }
//    public String getConfirmationToken() {
//        return confirmationToken;
//    }
//
//    public void setConfirmationToken(String confirmationToken) {
//        this.confirmationToken = confirmationToken;
//    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public int getYearsOfExperience() {
//        return yearsOfExperience;
//    }
//
//    public void setYearsOfExperience(int yearsOfExperience) {
//        this.yearsOfExperience = yearsOfExperience;
//    }
//
//    public Profession getProfession() {
//        return profession;
//    }
//
//    public void setProfession(Profession profession) {
//        this.profession = profession;
//    }
}


