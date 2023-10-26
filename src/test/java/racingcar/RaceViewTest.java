package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceViewTest {
    @Test
    void getCarInput_테스트() {
        String input = "test";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RaceView view = new RaceView();

        String result = view.getCarInput();
        assertEquals(input, result);
    }
}
