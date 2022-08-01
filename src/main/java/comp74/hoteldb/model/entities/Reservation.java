package comp74.hoteldb.model.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

//  
//  CREATE TABLE RESERVATION(
//  RESERVATION_ID BIGSERIAL PRIMARY KEY,
//  ROOM_ID BIGINT NOT NULL,
//  GUEST_ID BIGINT NOT NULL,
//  RES_DATE DATE
//  );
// 


@Entity
@Data
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RESERVATION_ID")
    Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="ROOM_ID", nullable = true)    
    Room room;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="GUEST_ID", nullable = true)
    Guest guest;
    

    
    Date resDate;
}
