package featuretest;

import Controller.InputHandler;
import Model.RaceCarNames;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FeatureTest {

    @Test
    void 경주_할_자동차_이름을_입력받기() {
        InputHandler inputHandler = new InputHandler();

        String testInput = "TestRaceCar";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        inputHandler.receiveRaceCarNames();

        RaceCarNames testObject = inputHandler.getRaceCarNames();
        assertTrue(testObject.isRaceCarNamesEqual(testInput));
    }

    @Test
    void 자동차_각각의_이름_알아내기() {
        String testInput = "TestCar1,TestCar2,TestCar3";
        RaceCarNames raceCarNames = new RaceCarNames(testInput);

        List<String> predList = raceCarNames.parseCarNamesFromRaceCarInput();
        List<String> actualList = Arrays.asList("TestCar1", "TestCar2", "TestCar3");

        assertThat(predList).containsAll(actualList);
    }
}
