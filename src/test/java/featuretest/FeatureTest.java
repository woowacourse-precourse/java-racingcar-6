package featuretest;

import Model.RaceCarNames;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FeatureTest {

    @Test
    void 경주_할_자동차_이름을_입력받기() {
        String predInput = "TestRaceCar";
        InputStream inputStream = new ByteArrayInputStream(predInput.getBytes());
        System.setIn(inputStream);

        Application.receiveRaceCarNames();

        RaceCarNames predObject = Application.getRaceCarNames();
        RaceCarNames actualObject = new RaceCarNames("TestRaceCar");

        assertThat(predObject).isEqualTo(actualObject);
    }

    @Test
    void 자동차_각각의_이름_알아내기() {
        String testInput = "TestCar1,TestCar2,TestCar3";
        RaceCarNames raceCarNames = new RaceCarNames(testInput);

        List<String> predList = raceCarNames.parseCarNamesFromRaceCarInput();
        List<String> actualList = Arrays.asList("TestCar1", "TestCar2", "TestCar3");

        assertThat(predList).isEqualTo(actualList);
    }
}
