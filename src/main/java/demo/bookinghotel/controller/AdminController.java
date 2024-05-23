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
import demo.bookinghotel.models.admin;
import demo.bookinghotel.repository.adminRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private adminRepository adminRepository;

    // Get all admins
    @GetMapping("/admins")
    public List<admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Create admin rest api
    @PostMapping("/admins")
    public admin createAdmin(@RequestBody admin admin) {
        return adminRepository.save(admin);
    }

    // Get admin by id rest api
    @GetMapping("/admins/{id}")
    public ResponseEntity<admin> getAdminById(@PathVariable Long id) {
        admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));
        return ResponseEntity.ok(admin);
    }

    // Update admin rest api
    @PutMapping("/admins/{id}")
    public ResponseEntity<admin> updateAdmin(@PathVariable Long id, @RequestBody admin adminDetails) {

        admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id :" + id));

        admin.setName(adminDetails.getName());
        admin.setEmail(adminDetails.getEmail());
        admin.setPhone(adminDetails.getPhone());

        admin updatedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    // Delete admin REST API
    @DeleteMapping("/admins/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable Long id) {

        admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not exist with id: " + id));

        adminRepository.delete(admin);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

