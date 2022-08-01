
package comp74.hoteldb.model.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import comp74.hoteldb.model.entities.Room;

public interface RoomRepo  extends PagingAndSortingRepository<Room,Long>{
   
}