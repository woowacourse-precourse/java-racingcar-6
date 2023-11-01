package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.InputController;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

class InputTest {
    @Test
    @DisplayName("자동차 이름 입력 길이 5초과 테스트")
    public void carNameLengthOver5Test() {
        //given
        String carName = "aaaaaa";
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

    @Test
    @DisplayName("자동차 이름 입력 NULL 테스트")
    public void carNameIsNullTest() {
        //given
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    @DisplayName("자동차 이름 입력 중복 테스트")
    public void duplicatedCarNameTest() {
        //given
        List<String> carNames = Arrays.asList("user", "user");
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cars(carNames));
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 숫자 아닌 입력 처리 테스트")
    @ValueSource(strings = {"test"})
    public void getAttemptCountFromStringTest(String incorrectAttemptCountInput) {
        //given
        InputController inputController = new InputController();
        ByteArrayInputStream testIn = new ByteArrayInputStream(incorrectAttemptCountInput.getBytes());

        //when
        System.setIn(testIn);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                inputController::getAttemptCountFromUserInput);
    }
}
