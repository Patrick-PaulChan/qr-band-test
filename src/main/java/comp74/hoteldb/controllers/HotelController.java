package comp74.hoteldb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import comp74.hoteldb.model.entities.Room;
import comp74.hoteldb.model.entities.Reservation;
import comp74.hoteldb.model.repos.RoomRepo;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class HotelController {

    RoomRepo roomRepo;

    @Autowired
    public HotelController(RoomRepo roomRepo) {
        super();
        this.roomRepo = roomRepo;
    }

    /**
     * 
     * Function returns a page of size 10 of the elements inside roomRepo
     * 
     * pageNumber parameter tells which page to start from, index starting 0
     * Default value is set to 0 if not provided
     * 
     * sortBy parameter shows which room object field to sort by.
     * Default value is set to roomName if not provided
     * 
     * http://localhost:8080/api/rooms?pageNumber=1
     * http://localhost:8080/api/rooms?pageNumber=1&sortBy=roomNumber
     * http://localhost:8080/Page?pageNumber=
     * 
     * @param pageNumber
     * @param sortBy
     * @return
     */
    @ResponseBody
    @GetMapping("/rooms")
    public Page<Room> getRoomsPage(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "roomName") String sortBy) {
        
        
        PageRequest pageInfo;

        pageInfo = PageRequest.of(pageNumber, 10, Sort.by(sortBy));

        return (Page<Room>) roomRepo.findAll(pageInfo);
    }   


    @RequestMapping("/art")
    public String artist(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "roomName") String sortBy) {
        
        


        return "artist";
    }


    @GetMapping("/deleteStudent")
    public String deleteStudent() 
    {
                
        return "adminpage";
    }
    


    /*
    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return (List<Room>) roomRepo.findAll();
    }
    */

    /**
     * localhost:8080/api/rooms/N
     * 
     * Finds rooms by id, passed as pathvariable after "/rooms/"
     * 
     * Returns single room object, if there is no room, return null.
     *   
     * 
     * @param id
     * @return
     */
    @GetMapping("/rooms/{id}")
    public Room findRoomById(@PathVariable Long id)
    {
        Optional<Room> opt =  roomRepo.findById(id);
        if (!opt.isEmpty())
            return opt.get();
        return null;
    }

/**
 * * localhost:8080/api/rooms/8/res
 * 
 * shows any reservations attatched to a
 * 
 * @param id
 * @return
 */
    @RequestMapping ("/rooms/{id}/res")
    public List<Reservation>
    findReservationByRoomId(@PathVariable Long id)
    {
        Room room = roomRepo.findById(id).get();
        return room.getReservations();
    }




}
