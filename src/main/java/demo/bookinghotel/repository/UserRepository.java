package demo.bookinghotel.repository;

import java.util.Optional;

// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.bookinghotel.models.User;

// public interface UserRepository extends CrudRepository<User, Integer> {

// }

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByName(String name);

  Optional<User> findById(Integer id);

  Boolean existsByName(String name);

  Boolean existsByEmail(String email);
}
