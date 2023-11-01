package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;
import racingcar.domain.Car;

class UserInputValidateTest {
    private final UserInputValidate userInputValidate;

    public UserInputValidateTest() {
        userInputValidate = new UserInputValidate();
    }

    @DisplayName("자동차 이름은 5자 이하만 가능")
    @Test
    void passValid() {
        //given
        String[] names = new String[]{"pobi", "woni", "jun"};

        //when
        List<Car> cars = userInputValidate.validate(names);

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.stream().map(Car::getName)).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("자동차 이름 : Empty Input Test")
    @Test
    void carNameEmptyInputValid() {
        //given
        String[] names = new String[]{};

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidate.validate(names));

        //then
        assertTrue(exception.getMessage().contains(ExceptionMessage.EMPTY_INPUT_ERROR_MESSAGE.exceptionMessage));
    }

    @DisplayName("자동차 이름은 null 일 때")
    @Test
    void CarNameNullValid() {
        //given
        String[] names = null;

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidate.validate(names));

        //then
        assertTrue(exception.getMessage().contains(ExceptionMessage.NULL_INPUT_ERROR_MESSAGE.exceptionMessage));
    }


    @DisplayName("자동차 이름은 6자 이상인 경우")
    @Test
    void overFiveWord() {
        //given
        String[] names = new String[]{"pobiii", "woni", "jun"};

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidate.validate(names));

        //then
        assertTrue(exception.getMessage().contains(ExceptionMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.exceptionMessage));
    }

    @DisplayName("시도 할 횟수 입력 시 숫자만 입력 가능")
    @Test
    void notIntegerValue() {
        //given
        String moveCount = "abc";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidate.tryCountValidate(moveCount));

        //then
        assertTrue(exception.getMessage().contains(ExceptionMessage.NOT_INTEGER_VALUE_ERROR_MESSAGE.exceptionMessage));
    }

    @DisplayName("시도 할 횟수가 null 일 때")
    @Test
    void tryCountNullValid() {
        //given
        String moveCount = null;

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidate.tryCountValidate(moveCount));

        //then
        assertTrue(exception.getMessage().contains(ExceptionMessage.NULL_INPUT_ERROR_MESSAGE.exceptionMessage));
    }

    @DisplayName("시도 할 횟수 : Empty Input Test")
    @Test
    void tryCountEmptyInputValid() {
        //given
        String moveCount = "";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidate.tryCountValidate(moveCount));
        
        //then
        assertTrue(exception.getMessage().contains(ExceptionMessage.NOT_INTEGER_VALUE_ERROR_MESSAGE.exceptionMessage));
    }

    @DisplayName("시도 할 횟수 입력 시 1보다 작은 값 입력 불가")
    @Test
    void lowerThanZero() {
        //given
        String moveCount = "-1";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userInputValidate.tryCountValidate(moveCount));

        //then
        assertTrue(exception.getMessage().contains(ExceptionMessage.DISABLE_INPUT_ERROR_MESSAGE.exceptionMessage));
    }
}