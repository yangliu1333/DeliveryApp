import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Ignore
public class ImageTest {
    @Test
    public void testImage() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources/images/1.jpg"));
        Assert.assertEquals(bufferedImage.getWidth(), 800);
    }
}
