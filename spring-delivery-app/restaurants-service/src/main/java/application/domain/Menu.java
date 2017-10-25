package application.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class Menu implements Serializable{

    private List<Dish> dishes;
    private Long id;
    private Long restaurantId;
    private Date date;
    private Time timeOfDay;

}
