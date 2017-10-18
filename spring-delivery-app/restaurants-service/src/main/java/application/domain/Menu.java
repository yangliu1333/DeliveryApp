package application.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class Menu {

    private Map<Integer, List<Dish>> foodOptions;

    private List<Dish> drinkList;

    private Long id;

    private String timeOfDay;

    private Date date;

}
