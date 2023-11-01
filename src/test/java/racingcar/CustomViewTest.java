package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
public class CustomViewTest {

    CustomView customView = new CustomView();

    @Test
    public void strSplitTest() {
        String input = "car1, car2,car3";
        List<String> expected = Arrays.asList("car1", "car2", "car3");
        List<String> result = customView.strSplit(input);
        assertEquals(expected, result);
    }

    @Test
    public void strTrimTest() {
        String[] input = {" car1 ", " car2", "car3 "};
        List<String> expected = Arrays.asList("car1", "car2", "car3");
        List<String> result = customView.strTrim(input);
        assertEquals(expected, result);
    }

    @Test
    public void intToStrTest() {
        int input = 3;
        StringBuilder result = customView.intToStr(input);
        assertEquals("---", result.toString());
    }
}
