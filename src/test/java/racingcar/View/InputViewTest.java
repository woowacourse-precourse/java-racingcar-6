package racingcar.View;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.View.InputView.getCarName;
import static racingcar.View.InputView.getNumberOfRound;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void inputCarName() {
        String testCarNames = "test1,test2,test3";
        System.setIn(new ByteArrayInputStream(testCarNames.getBytes()));
        String result = getCarName();
        assertEquals("test1,test2,test3", result);
    }

    @Test
    void inputNumberOfRound() {
        String testNumberOfRound = "5";
        System.setIn(new ByteArrayInputStream(testNumberOfRound.getBytes()));
        String result = getNumberOfRound();
        assertEquals("5", result);
    }
}