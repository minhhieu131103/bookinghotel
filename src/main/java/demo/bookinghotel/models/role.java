package demo.bookinghotel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private crole name;

  public role() {

  }

  public role(crole name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public crole getName() {
    return name;
  }

  public void setName(crole name) {
    this.name = name;
  }
}