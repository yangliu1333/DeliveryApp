package application.rest;

import application.domain.Dish;
import application.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(value = "/dish")
public class DishRestController {
    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_SIZE = "10";
    private static final String IMAGE_PATH = "src/main/resources/images/";
    private static final String JPG_FORMAT = "jpg";

    @Autowired
    private MenuService service;

    @RequestMapping(value = "/restaurant/{restaurantId}", method = RequestMethod.GET)
    public Page<Dish> getAvailableDishes(@PathVariable("restaurantId") Long restaurantId,
                                         @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                         @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size) {
        return service.getDishes(restaurantId, new PageRequest(page, size));
    }

    @RequestMapping(value = "/image/{dishId}", headers = "Accept=image/jpeg",method = RequestMethod.GET)
    public byte[] getDishPicture(@PathVariable("dishId") String dishId) {
        byte[] result = null;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
            BufferedImage bufferedImage = ImageIO.read(new File(IMAGE_PATH + dishId + ".jpg"));
            ImageIO.write(bufferedImage, JPG_FORMAT, outputStream);
            outputStream.flush();
            result = outputStream.toByteArray();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return result;
    }
}
