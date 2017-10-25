package application.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Data
@Table(name = "restaurants")
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private RestaurantStatus status;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private double rating;

    @Transient
    private Menu currentMenu;

    @Column(name = "address")
    private String address;

    @Transient
    private List<Comment> comments;

    public Restaurant(){};

}
