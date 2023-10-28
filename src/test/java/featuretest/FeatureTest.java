package featuretest;

import Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FeatureTest {

    @Test
    void 경주_할_자동차_이름을_입력받기() {
        String predInput = "TestRaceCar";
        InputStream inputStream = new ByteArrayInputStream(predInput.getBytes());
        System.setIn(inputStream);

        Application.receiveRaceCarNames();

        RaceCarNames actualObject = Application.getRaceCarNames();
        RaceCarNames expectedObject = new RaceCarNames("TestRaceCar");

        assertThat(actualObject).isEqualTo(expectedObject);
    }

    @Test
    void 자동차_각각의_이름_알아내기() {
        String testInput = "TestCar1,TestCar2,TestCar3";
        RaceCarNames raceCarNames = new RaceCarNames(testInput);

        List<String> actualList = raceCarNames.parseCarNamesFromRaceCarInput();
        List<String> expectedList = Arrays.asList("TestCar1", "TestCar2", "TestCar3");

        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    void 시도할_회수_입력받기() {
        String predInput = "5";
        InputStream inputStream = new ByteArrayInputStream(predInput.getBytes());
        System.setIn(inputStream);

        Application.receiveTryCount();

        TryCount actualObject = Application.getTryCount();
        TryCount expectedObject = new TryCount("5");

        assertThat(actualObject).isEqualTo(expectedObject);
    }

    @ParameterizedTest
    @CsvSource({
            "5, true",
            "abcde, false",
            "53e1f, false"
    })
    void 시도_회수가_숫자인지_확인(String testTryCount, boolean expectedResult) {
        TryCount tryCount = new TryCount(testTryCount);
        boolean actualResult = tryCount.isTryCountNumeric();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "mycar, true",
            "myfantasticcar, false",
            "iamcar, false"
    })
    void 자동차_이름이_5자_이하인지_확인(String testCarName, boolean expectedResult) {
        CarName carName = new CarName(testCarName);
        boolean actualResult = carName.isNameUnder5Characters();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 자동차_이름이_공백인지_확인() {
        CarName carName = new CarName("");
        boolean actualResult = carName.isCarNameEmpty();
        boolean expectedResult = true;

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 자동차_전진() {
        CarPosition actualObj = new CarPosition(3);
        actualObj.moveCarForward();
        CarPosition expectedObj = new CarPosition(4);

        assertThat(actualObj).isEqualTo(expectedObj);
    }
}
