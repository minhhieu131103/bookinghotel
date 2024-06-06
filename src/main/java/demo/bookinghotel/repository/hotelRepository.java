package demo.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.bookinghotel.models.hotel;

@Repository
public interface hotelRepository extends JpaRepository<hotel, Long> {
    
}
