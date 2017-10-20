package application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "T_DISH")
public class Dish {

    @JsonIgnore
    private List<Menu> menus;
    private Long id;
    private String name;
    private DishType dishType;

    @ManyToMany(mappedBy = "dishes", cascade = CascadeType.ALL)
    public List<Menu> getMenus() {
        return menus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public Dish() {}

}
