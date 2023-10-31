package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarValidatorTest {

    @DisplayName("리스트에 담긴 자동차 이름 중 중복값이 있으면 예외 발생")
    @Test
    void duplicatedCarNameInNameListThrowException() {
        List<String> nameList = new ArrayList<>();
        nameList.add("pobi");
        nameList.add("pobi");
        nameList.add("woni");

        assertThatThrownBy(
                () -> CarValidator.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.DUPLICATED_CAR_NAME_NOT_ALLOWED);
    }

    @DisplayName("자동차 이름의 문자열의 길이가 5 초과면 예외 발생")
    @Test
    void carNameLengthOverFiveThrowException() {
        String carNameOverLengthFive = "pobiii";

        assertThatThrownBy(
                () -> CarValidator.validateCarName(carNameOverLengthFive))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.LENGTH_MAX_FIVE_ALLOWED);
    }

    @DisplayName("리스트에 담긴 자동차 이름의 문자열의 길이가 1 미만이면 예외 발생")
    @Test
    void carNameLengthUnderOneThrowException() {
        String carNameLengthUnderOne = "";

        assertThatThrownBy(
                () -> CarValidator.validateCarName(carNameLengthUnderOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.LENGTH_MIN_ONE_ALLOWED);
    }

    @DisplayName("리스트에 담긴 자동차가 2개 미만이면 예외 발생")
    @Test
    void carListUnderTwoThrowException() {
        assertThatThrownBy(
                () -> CarValidator.validateCarListSize(List.of(new Car("pobi"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.MORE_THAN_TWO_CARS_ALLOWED);
    }

    @DisplayName("자동차 이름이 숫자/한글/영어 외의 문자열이면 예외 발생.")
    @Test
    void carNameNotOnlyHasCharacterOrNumber() {
        String notOnlyHasCharacterOrNumber = "#pobi";

        assertThatThrownBy(
                () -> CarValidator.validateCarName(notOnlyHasCharacterOrNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidator.ONLY_HAS_CHARACTER_OR_NUMBER_ALLOWED);
    }


}