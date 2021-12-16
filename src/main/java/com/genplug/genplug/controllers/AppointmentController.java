package com.genplug.genplug.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.genplug.genplug.classes.*;
import com.genplug.genplug.repositories.AppointmentRepository;
import com.genplug.genplug.repositories.ClientRepository;
import com.genplug.genplug.repositories.ProfessionalRepository;
import com.genplug.genplug.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    ProfessionalRepository professionalRepository;

    @Autowired
    ClientRepository clientRepository;

    @PostMapping(path = "/appointments/create", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Appointment createAppointment(@RequestBody ObjectNode objectNode) throws ParseException {
        String date = objectNode.get("date").asText();
        String time = objectNode.get("time").asText();
        String professionalName = objectNode.get("professional_name").asText();
        String clientName = objectNode.get("client_name").asText();

        Appointment appointment = new Appointment();

        List<Professional> professionalList = (List<Professional>) professionalRepository.findAll();
        for (Professional professional:professionalList
        ) {
            if (professional.getName().equals(professionalName)){
                appointment.setProfessionalAcc(professional);
            }
        }

        List<Client> clientList = (List<Client>) clientRepository.findAll();
        for (Client client:clientList
        ) {
            if (client.getName().equals(clientName)){
                appointment.setClientAcc(client);
            }
        }

        Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        appointment.setDate(newDate);

        Date newTime = new SimpleDateFormat("HH:mm").parse(time);
        appointment.setTime(newTime);

        appointmentService.createAppointment(appointment);
        return appointment;

    }

    @GetMapping(path="/appointments/viewrequests", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Appointment> viewAppointmentRequests(@Email @RequestParam String email){
        return appointmentService.viewAppointmentRequests(email);
    }

    @PostMapping(path="/appointments/{id}/accept", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Appointment acceptAppointment(@PathVariable("id") Long appointmentId){

        return appointmentService.acceptAppointment(appointmentId);

    }

    @PostMapping(path="/appointments/{id}/decline", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Appointment declineAppointment(@PathVariable("id") Long appointmentId){
        return appointmentService.declineAppointment(appointmentId);
    }
}
