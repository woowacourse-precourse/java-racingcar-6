package racingcar.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Controller.RaceGame.getCarsName;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class RaceGameTest {

    @Test
    void 이름_입력_성공(){
        String input = "Car1,Car2,Car3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ArrayList<String> carNames = getCarsName();

        ArrayList<String> expectedCarNames = new ArrayList<>();
        expectedCarNames.add("Car1");
        expectedCarNames.add("Car2");
        expectedCarNames.add("Car3");

        assertEquals(carNames,expectedCarNames);
    }
}