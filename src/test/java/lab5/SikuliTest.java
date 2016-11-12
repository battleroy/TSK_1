package lab5;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class SikuliTest {

    public void sendTelegramSticker() {

        Screen s = new Screen();

        try {
            for (int i = 0; i < 4; ++i) {
                s.click("/Users/lenovo/Desktop/" + (i + 1) + ".png");
                s.wait(1.0f);
            }
        } catch (FindFailed e) {
            e.printStackTrace();
        }

    }

}
