package application.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dish implements Serializable{

    private Long id;
    private String name;
    private DishType dishType;
}
