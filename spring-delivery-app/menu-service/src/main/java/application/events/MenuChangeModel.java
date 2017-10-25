package application.events;

import java.util.UUID;

public class MenuChangeModel{

    private String type;
    private Long restaurantId;
    private Long menuId;
    private String action;
    private String correlationId;

    public MenuChangeModel(String type, Long restaurantId, Long menuId, String action) {
        super();
        this.type = type;
        this.restaurantId = restaurantId;
        this.menuId = menuId;
        this.action = action;
        this.correlationId = UUID.randomUUID().toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
