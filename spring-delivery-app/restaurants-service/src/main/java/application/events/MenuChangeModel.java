package application.events;

public class MenuChangeModel {

    private String type;
    private Long restaurantId;
    private Long menuId;
    private String action;
    private String correlationId;

    public MenuChangeModel() {
        super();
    }

    public MenuChangeModel(String type, Long restaurantId, Long menuId, String action, String correlationId) {
        super();
        this.type = type;
        this.restaurantId = restaurantId;
        this.menuId = menuId;
        this.action = action;
        this.correlationId = correlationId;
    }

    public String getType() {
        return type;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public String getAction() {
        return action;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
