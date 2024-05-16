package demo.bookinghotel.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "name"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 128)
  private String name;

  @NotBlank
  @Size(max = 128)
  @Email
  private String email;

  @NotBlank
  @Size(max = 128)
  private String phone;

  @NotBlank
  @Size(max = 128)
  private String address;

  @NotBlank
  @Size(max = 128)
  private String password;
  
  @NotBlank
  @Size(max = 128)
  private String price;

  public User() {
  }

  public User(String name, String email, String phone, String address, String password, String price) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.password = password;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

}
