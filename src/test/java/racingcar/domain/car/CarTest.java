package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "ghijkl", "mnopqrs"})
    @DisplayName("자동차 이름 입력 다섯 자 초과인 경우 예외 처리")
    void carNameIsTooLongErrorTest(final String name) {
        final String message = ErrorMessages.CAR_NAME_IS_TOO_LONG.getMessage();
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(InvalidArgumentException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    @DisplayName("자동차 이름 입력 NULL 혹은 공백일 경우 예외 처리")
    void carNameIsNullOrBlankErrorTest(final String name) {
        final String message = ErrorMessages.CAR_NAME_IS_NULL_OR_BLANK.getMessage();
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(InvalidArgumentException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun", "a b"})
    @DisplayName("자동차 객체 생성 테스트")
    void carObjectCreationTest(final String name) {
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
}
