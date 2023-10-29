package featuretest;

import Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FeatureTest {

    @Test
    void 자동차_이름_빈_문자열() {
        String testCarName = "";
        CarName carName = new CarName(testCarName);

        boolean actualResult = carName.isEmpty();
        boolean expectedResult = true;

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 자동차_이름_다섯_글자_초과() {
        String testCarName = "myfavoritecar";
        CarName carName = new CarName(testCarName);

        boolean actualResult = carName.isUnder5Characters();
        boolean expectedResult = false;

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "car1, true",
            "mycar, true",
            "Iamcar, false",
            "'', false"
    })
    void 자동차_이름_유효성_테스트(String carName, boolean expectedResult) {
        Car car = new Car(carName);

        boolean actualResult = car.isNameValid();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 자동차_이름_파싱() {
        String testCarNames = "car1,car2,car3";
        RaceCarNames raceCarNames = new RaceCarNames(testCarNames);

        List<String> actualCarNames = raceCarNames.parseCarNamesFromInput();
        List<String> expectedCarNames = List.of("car1", "car2", "car3");

        assertThat(actualCarNames).containsExactlyElementsOf(expectedCarNames);
    }

    @ParameterizedTest
    @CsvSource({
            "4, true",
            "10, true",
            "car1, false",
            "mycar, false"
    })
    void 시도_횟수_숫자_확인(String testTryCount, boolean expectedResult) {
        TryCount tryCount = new TryCount(testTryCount);

        boolean actualResult = tryCount.isNumeric();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void 자동차_전진() {
        Car testCar = new Car("car1");
        int moveCount = 5;
        for (int i = 1; i <= moveCount; i++) {
            testCar.moveForward();
        }

        int actualPosition = testCar.getPosition();
        int expectedPosition = moveCount;

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}
