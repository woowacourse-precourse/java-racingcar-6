package featuretest;

import Controller.InputHandler;
import Model.RaceCarNames;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FeatureTest {

    @Test
    void 경주_할_자동차_이름을_입력받기 () {
        InputHandler inputHandler = new InputHandler();

        String testInput = "TestRaceCar";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        inputHandler.receiveRaceCarNames();

        RaceCarNames testObject = inputHandler.getRaceCarNames();
        assertTrue(testObject.isRaceCarNamesEqual(testInput));
    }
}
