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

// CREATE TABLE GUEST(
//   GUEST_ID BIGSERIAL PRIMARY KEY,
//   FIRST_NAME VARCHAR(64),
//   LAST_NAME VARCHAR(64),
//   EMAIL_ADDRESS VARCHAR(64),
//   ADDRESS VARCHAR(64),
//   COUNTRY VARCHAR(32),
//   STATE VARCHAR(12),
//   PHONE_NUMBER VARCHAR(24)
// );

@Entity
@Data
@NoArgsConstructor
public class Guest {

    @Id
    @Column(name="GUEST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;

    String lastName;

    String emailAddress;

    String address;

    String country;

    String state;

    String phoneNumber;

    @OneToMany(mappedBy = "guest")
    @JsonManagedReference
    List<Reservation> reservations = new ArrayList<>();

}
