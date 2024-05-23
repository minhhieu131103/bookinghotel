package demo.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.bookinghotel.models.admin;

@Repository
public interface adminRepository extends JpaRepository<admin, Long> {
}
