package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.constantMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.constant.constantMessage.NEGATIVE_VALUE_ERROR_MESSAGE;
import static racingcar.constant.constantMessage.Not_Integer_VALUE_ERROR_MESSAGE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("자동차 이름은 6자 이상인 경우")
    @Test
    void overFiveWord() {
        //given
        String[] names = new String[]{"pobiii", "woni", "jun"};

        //then
        assertThrows(IllegalArgumentException.class, () -> userInputValidate.validate(names))
                .getMessage().contains(CAR_NAME_LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("시도 할 횟수 입력 시 숫자만 입력 가능")
    @Test
    void notIntegerValue() {
        //given
        String moveCount = "abc";

        //then
        assertThrows(IllegalArgumentException.class, () -> userInputValidate.tryCountValidate(moveCount))
                .getMessage().contains(Not_Integer_VALUE_ERROR_MESSAGE);
    }


    @DisplayName("시도 할 횟수 입력 시 0보다 작은 값 입력 불가")
    @Test
    void lowerThanZero() {
        //given
        String moveCount = "-1";

        //then
        assertThrows(IllegalArgumentException.class, () -> userInputValidate.tryCountValidate(moveCount))
                .getMessage().contains(NEGATIVE_VALUE_ERROR_MESSAGE);
    }
}