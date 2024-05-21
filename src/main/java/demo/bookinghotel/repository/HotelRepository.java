package demo.bookinghotel.repository;

import org.springframework.data.repository.CrudRepository;

import demo.bookinghotel.models.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}

