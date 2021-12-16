package com.genplug.genplug.services;

import com.genplug.genplug.classes.Appointment;
import com.genplug.genplug.classes.Professional;
import com.genplug.genplug.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    // create appointment
    public void createAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }

    //view appointment requests
    public List<Appointment> viewAppointmentRequests(String email){
        List<Appointment> finalList = new ArrayList<>();

        List<Appointment> appointmentsList = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment appointment:appointmentsList) {
            if (appointment.getProfessionalAcc().getEmail().equals(email) && appointment.getAccepted()==null){
                finalList.add(appointment);
            }
        }
        return finalList;
    }

    public Appointment acceptAppointment(Long appointmentId){
        Appointment foundAppointment = appointmentRepository.findById(appointmentId).get();
        foundAppointment.setAccepted(true);
        appointmentRepository.save(foundAppointment);
        return foundAppointment;
    }

    public Appointment declineAppointment(Long appointmentId){
        Appointment foundAppointment = appointmentRepository.findById(appointmentId).get();
        foundAppointment.setAccepted(false);
        appointmentRepository.save(foundAppointment);
        return foundAppointment;
    }

}
