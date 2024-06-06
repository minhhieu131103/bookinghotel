package demo.bookinghotel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "star")
    private Integer star;

    @Column(name = "price")
    private String price;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    @Lob
    @Column(name = "image2", columnDefinition = "LONGBLOB")
    private byte[] image2;

    @Column(name = "description")
    private String description;  // New field for description

    public hotel() {
    }

    public hotel(Long id, String name, String address, Integer star, String price, byte[] image, byte[] image2, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.star = star;
        this.price = price;
        this.image = image;
        this.image2 = image2;
        this.description = description;  // Initialize the new field
    }

    // Getters and setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public String getDescription() {
        return description;  
    }

    public void setDescription(String description) {
        this.description = description;  
    }
}
