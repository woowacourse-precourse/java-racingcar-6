package racingcar.domain.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarDtoParser;

class CarDtoParserTest {

    @Test
    @DisplayName("주어진 자동차 이름들을 ,로 구분합니다.")
    void splitNames() {
        // GIVEN
        String carNames = "pobipobi,qwe,ert";
        String[] cars = {"pobipobi", "qwe", "ert"};

        // WHEN
        String[] splittedNames = CarDtoParser.trimAndSplit(carNames);

        // THEN
        assertTrue(Arrays.equals(cars, splittedNames));
    }

    @Test
    @DisplayName("주어진 자동차 이름 내에 공백이 있다면 공백을 제거하고 ,로 구분합니다.")
    void trimAndSplitNames() {
        // GIVEN
        String carNames = "pobipobi         ,qwe,       ert";
        String[] cars = {"pobipobi", "qwe", "ert"};

        // WHEN
        String[] splittedNames = CarDtoParser.trimAndSplit(carNames);

        // THEN
        assertTrue(Arrays.equals(cars, splittedNames));
    }

}