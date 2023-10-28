package featuretest;

import Model.*;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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
    void 자동차_이름_다섯_글자_초과() {
        String testRaceCarNames = "mycar1,car2,car3";
        InputStream inputStream = new ByteArrayInputStream(testRaceCarNames.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(Application::receiveRaceCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_비어있음() {
        String testRaceCarNames = "mycar1,  ,car3";
        InputStream inputStream = new ByteArrayInputStream(testRaceCarNames.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(Application::receiveRaceCarNames)
                .isInstanceOf(IllegalArgumentException.class);
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

    @Test
    void 시도_횟수_숫자_아님() {
        String testTryCount = "car1";
        InputStream inputStream = new ByteArrayInputStream(testTryCount.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(Application::receiveTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진() {
        CarPosition actualObj = new CarPosition(3);
        actualObj.moveCarForward();
        CarPosition expectedObj = new CarPosition(4);

        assertThat(actualObj).isEqualTo(expectedObj);
    }

//    @Test
//    void 랜덤_값_생성() {
//        Car actualObj = new Car();
//        actualObj.generateRandomNumber();
//
//        boolean actualResult = actualObj.isRandomNumberInRange0to9();
//        boolean expectedResult = true;
//
//        assertThat(actualResult).isEqualTo(expectedResult);
//    }
}
