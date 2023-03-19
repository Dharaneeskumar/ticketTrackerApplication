package com.glproject.tickettrackingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
public class Tickets {
@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
String title;
String description;
String date;
String content;
public Tickets(){
        Date date1=new Date();

        this.date= String.valueOf(date1.getDate()+"/"+date1.getMonth()+"/"+date1.getYear());
}


}
