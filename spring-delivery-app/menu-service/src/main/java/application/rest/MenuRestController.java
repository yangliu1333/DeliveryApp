package application.rest;

import application.domain.Menu;
import application.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuRestController {

    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_SIZE = "10";

    @Autowired
    private MenuService service;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Menu menu) {
        service.updateMenu(menu);
    }

    @RequestMapping(value = "/{restaurantId}/latest", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Menu getLatest(@PathVariable("restaurantId") Long restaurantId) {
        return service.getLatestMenu(restaurantId);
    }

    @RequestMapping(value = "/{restaurantId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Page<Menu> getHistoryMenus(@PathVariable("restaurantId") Long restaurantId,
                                      @RequestParam(required = false, defaultValue = DEFAULT_PAGE) int page,
                                      @RequestParam(required = false, defaultValue = DEFAULT_SIZE) int size) {
        return service.getHistoryMenuByRestaurant(restaurantId, new PageRequest(page, size));
    }
}
