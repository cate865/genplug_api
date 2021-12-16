package com.genplug.genplug.classes;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="appointments")
public class Appointment {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "appointment_id")
        private Long appointmentId;

        @Temporal(TemporalType.DATE)
        @Column(name="appt_date")
        @JsonFormat(pattern="yyyy-MM-dd")
        private Date date;

        @Temporal(TemporalType.TIME)
        @Column(name="appt_time")
        @JsonFormat(pattern="HH:mm")
        private Date time;

        @Column(name="accepted")
        private Boolean accepted;

        @ManyToOne
        @JoinColumn(name="prof_email",unique = true)
        private Professional professionalAcc;

        @ManyToOne
        @JoinColumn(name="client_email",unique = true)
        private Client clientAcc;

        public Appointment() {

        }

        public Appointment(Date date, Date time,Boolean accepted, Professional professionalAcc, Client clientAcc) {
                this.date = date;
                this.time = time;
                this.accepted = accepted;
//                this.professionalAcc = professionalAcc;
//                this.clientAcc = clientAcc;
        }


        public Long getAppointmentId() {
                return appointmentId;
        }
        public void setAppointmentId(Long appointmentId) {
                this.appointmentId = appointmentId;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public Date getTime() {
                return time;
        }

        public void setTime(Date time) {
                this.time = time;
        }

        public Boolean getAccepted() {
                return accepted;
        }

        public void setAccepted(Boolean accepted) {
                this.accepted = accepted;
        }

        public Professional getProfessionalAcc() {
                return professionalAcc;
        }

        public void setProfessionalAcc(Professional professionalAcc) {
                this.professionalAcc = professionalAcc;
        }

        public Client getClientAcc() {
                return clientAcc;
        }

        public void setClientAcc(Client clientAcc) {
                this.clientAcc = clientAcc;
        }
}


