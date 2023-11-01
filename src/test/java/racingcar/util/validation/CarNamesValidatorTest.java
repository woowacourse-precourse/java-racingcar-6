package racingcar.util.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.CarName;

class CarNamesValidatorTest {

    private static final Integer MIN_CAR_NAME_SIZE = 2;
    private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름에 빈 값은 허용되지 않습니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "중복된 자동차 이름이 존재합니다.";
    private static final String MIN_CAR_NAME_SIZE_ERROR_MESSAGE = "최소 %s개 이상의 자동차 이름을 입력하셔야 합니다.";

    @DisplayName("유효한 자동차 이름 목록이 주어진 경우 예외가 발생하지 않는다.")
    @Test
    void validCarNames_test() {
        List<CarName> carNames = Arrays.asList(
                new CarName("Car1"),
                new CarName("Car2"),
                new CarName("Car3"));

        assertDoesNotThrow(() -> {
            CarNamesValidator.validateCarNames(carNames);
        });
    }

    @DisplayName("자동차 이름에 빈 값이 포함될 경우 예외가 발생한다.")
    @Test
    void empty_CarName_exception_test() {
        List<CarName> carNames = Arrays.asList(new CarName("Car1"), new CarName(""));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> CarNamesValidator.validateCarNames(carNames));
        assertEquals(EMPTY_CAR_NAME_ERROR_MESSAGE, e.getMessage());
    }

    @DisplayName("자동차 이름에 중복된 이름이 있을 경우 예외가 발생한다.")
    @Test
    void duplicate_CarName_exception_test() {
        List<CarName> carNames = Arrays.asList(new CarName("Car1"), new CarName("Car1"));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> CarNamesValidator.validateCarNames(carNames));
        assertEquals(DUPLICATE_CAR_NAME_ERROR_MESSAGE, e.getMessage());
    }


    @DisplayName("자동차 이름의 개수가 최소 개수보다 작은 경우 예외가 발생한다.")
    @Test
    void carNameListSmallerThanMin_test() {
        List<CarName> carNames = Arrays.asList(
                new CarName("Car1"));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> CarNamesValidator.validateCarNames(carNames));

        String errorMessage = String.format(MIN_CAR_NAME_SIZE_ERROR_MESSAGE, MIN_CAR_NAME_SIZE);
        assertEquals(errorMessage, e.getMessage());
    }
}
