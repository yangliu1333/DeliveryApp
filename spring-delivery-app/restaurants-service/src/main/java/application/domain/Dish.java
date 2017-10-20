package application.domain;

import lombok.Data;

@Data
public class Dish {

    private Long id;
    private String name;
    private DishType dishType;
}
