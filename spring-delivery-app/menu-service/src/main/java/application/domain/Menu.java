package application.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "menu")
public class Menu {

    private Map<Integer, List<Dish>> foodOptions;

    private List<Dish> drinkList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long restaurantId;

    private Date date;

    private Time timeOfDay;

}
