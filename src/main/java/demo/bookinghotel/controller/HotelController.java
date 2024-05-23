package demo.bookinghotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.bookinghotel.exception.ResourceNotFoundException;
import demo.bookinghotel.models.hotel;
import demo.bookinghotel.repository.hotelRepository;

@SuppressWarnings("unused")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    private hotelRepository hotelRepository;

    // Get all hotel
    @GetMapping("/hotel")
    public List<hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    // Get hotel by id
    @GetMapping("/hotel/{id}")
    public ResponseEntity<hotel> getHotelById(@PathVariable Long id) {
        hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
        return ResponseEntity.ok(hotel);
    }

    // Create a new hotel
    @PostMapping("/hotel")
    public hotel createHotel(@RequestBody hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Update a hotel
    @PutMapping("/hotel/{id}")
    public ResponseEntity<hotel> updateHotel(@PathVariable Long id, @RequestBody hotel hotelDetails) {
        hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        hotel.setName(hotelDetails.getName());
        hotel.setAddress(hotelDetails.getAddress());
        hotel.setStar(hotelDetails.getStar());
        hotel.setPrice(hotelDetails.getPrice());

        final hotel updatedHotel = hotelRepository.save(hotel);
        return ResponseEntity.ok(updatedHotel);
    }

    // Delete a hotel
    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id) {
        hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        hotelRepository.delete(hotel);

        return ResponseEntity.ok().build();
    }
}

