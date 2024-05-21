package demo.bookinghotel.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.bookinghotel.repository.HotelRepository;
import demo.bookinghotel.models.Hotel;

@RestController
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping(path = "/hotelall")
    @CrossOrigin
    @ResponseBody
    public  List<Hotel> getAllHotels() {
      // This returns a JSON or XML with the users
      return (List<Hotel>) hotelRepository.findAll();
    }

    @GetMapping(path = "/hotelbyid/{id}")
    @ResponseBody
    public Hotel getHotelById(@PathVariable Integer id) {
      // This returns a JSON or XML with the users
      Hotel h=hotelRepository.findById(id)
                                .orElse(new Hotel());
      return (h);
    }

    @PostMapping("/themhotel")
    @CrossOrigin
  public void createHotel(@RequestBody Hotel h) {
    hotelRepository.save(h);
  }

  //   @PostMapping("/xoahotelbyid/{id}")
  //   @CrossOrigin
  // public void deleteHotelById(@RequestBody Hotel h) {
  //   Integer id = h.getId();
  //   hotelRepository.deleteById(id);
  // }

    @GetMapping(path = "/xoahotelbyid/{id}")
    @ResponseBody
    public void deleteHotelById(@PathVariable Integer id) {
      hotelRepository.deleteById(id);
  }

}

