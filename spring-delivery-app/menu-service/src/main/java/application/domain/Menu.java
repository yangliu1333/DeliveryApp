package application.domain;

import lombok.Data;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "T_MENU")
public class Menu {

    private List<Dish> dishes;
    private Long id;
    private Long restaurantId;
    private Date date;
    private Time timeOfDay;

    @ManyToMany(targetEntity = Dish.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="T_MENU_DISH",
            joinColumns={@JoinColumn(name="MENU_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="DISH_ID", referencedColumnName="ID")})
    public List<Dish> getDishes() {
        return dishes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public Menu() {}

}
