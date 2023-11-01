package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.util.TypeConverter;
import racingcar.util.Validator;

class InputTest {
    private final String[] input = new String[3];

    @Test
    @DisplayName("입력한 자동차 개수만큼 Car 객체가 생성된다.")
    void generateCarTest() {
        input[0] = "car1";
        input[1] = "car2";
        input[2] = "car3";

        for (String carName : input) {
            assertThatCode(() -> Validator.validateCarName(carName))
                    .doesNotThrowAnyException();
        }
        List<Car> cars = TypeConverter.convertStringArrayToCarList(input);
        assertThat(cars).hasSize(input.length);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름의 길이가 1이상 5이하가 아니라면 예외가 발생한다.")
    @ValueSource(strings = {"carcarcarcar", "abcdef", ""})
    void validateLengthTest(String carName) {
        assertThatThrownBy(() -> Validator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 공백이 포함되었다면 예외가 발생한다.")
    @ValueSource(strings = {"car ", "c ar", "ca r"})
    void validateBlankTest(String carName) {
        assertThatThrownBy(() -> Validator.validateBlank(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 자동차 이름이 있다면 예외가 발생한다.")
    void validateLengthTest() {
        input[0] = "car";
        input[1] = "car";
        input[2] = "car";

        assertThatThrownBy(() -> Validator.validateDuplicate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력한 회수 만큼 round 값이 설정된다.")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void generateRoundTest(String round) {
        assertThatCode(() -> Validator.validateRound(round))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("입력한 회수가 1이상의 자연수 형태가 아니라면 예외가 발생한다.")
    @ValueSource(strings = {"0", "abc", "-1"})
    void validateRoundTest(String round) {
        assertThatThrownBy(() -> Validator.validateRound(round))
                .isInstanceOf(IllegalArgumentException.class);
    }
}