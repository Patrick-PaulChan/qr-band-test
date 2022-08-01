package comp74.hoteldb.model.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

// 
//  CREATE TABLE ROOM
//  (    ROOM_ID BIGINT AUTO_INCREMENT PRIMARY KEY, 
//       NAME VARCHAR(16) NOT NULL, 
//       ROOM_NUMBER CHAR(2) NOT NULL UNIQUE, 
//       BED_INFO CHAR(2) NOT NULL
//   );
//

@Data
@Entity
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long roomId;

    @Column(name="NAME")
    String roomName;

    String roomNumber;  // roomNumber => ROOM_NUMBER 

    String bedInfo;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    List<Reservation> reservations = new ArrayList<>();

}
