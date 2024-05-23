package demo.bookinghotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.bookinghotel.models.crole;
import demo.bookinghotel.models.role;

@Repository
public interface roleRepository extends JpaRepository<role, Long> {
  Optional<role> findByName(crole name);
}
