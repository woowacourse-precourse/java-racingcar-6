package featuretest;

import Model.CarName;
import Model.RaceCarNames;
import Model.TryCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @Test
    void 시도할_회수_입력받기() {
        String predInput = "5";
        InputStream inputStream = new ByteArrayInputStream(predInput.getBytes());
        System.setIn(inputStream);

        Application.receiveTryCount();

        TryCount predObject = Application.getTryCount();
        TryCount actualObject = new TryCount("5");

        assertThat(predObject).isEqualTo(actualObject);
    }

    @ParameterizedTest
    @CsvSource({
            "5, true",
            "abcde, false",
            "53e1f, false"
    })
    void 시도_회수가_숫자인지_확인(String tryCountInput, boolean actualResult) {
        TryCount tryCount = new TryCount(tryCountInput);
        assertThat(tryCount.isTryCountNumeric()).isEqualTo(actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "mycar, true",
            "myfantasticcar, false",
            "iamcar, false"
    })
    void 자동차_이름이_5자_이하인지_확인(String testCarName, boolean actualResult) {
        CarName carName = new CarName(testCarName);
        boolean predResult = carName.isNameUnder5Characters();

        assertThat(predResult).isEqualTo(actualResult);
    }
}
