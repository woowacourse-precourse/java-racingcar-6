package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Domain.Car;

public class CarTest {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    @ParameterizedTest
    @DisplayName("구분자로 분리한 이름의 길이가 1 이상 5 이하가 아닌 경우 예외 테스트")
    @ValueSource(strings = {"", "masonkim"})
    void isValidName(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 "
                        + MINIMUM_NAME_LENGTH + "자에서 최대 "
                        + MAXIMUM_NAME_LENGTH + "자 사이로 입력하셔야 합니다.");
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void checkMoveAvailable() {
        Car car = new Car("mason");
        car.moveForward(5);
        assertThat(car.isSamePosition(1)).isTrue();
    }
}
