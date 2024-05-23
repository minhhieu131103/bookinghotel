package demo.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.bookinghotel.models.service;

@Repository
public interface serviceRepository  extends JpaRepository<service, Long>{

}
