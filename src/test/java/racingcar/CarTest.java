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
    private static final String POSITION_STAMP = "-";

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

    @Test
    @DisplayName("자동차 정지 테스트")
    void checkNoMoveAvailable() {
        Car car = new Car("mason");
        car.moveForward(3);
        assertThat(car.isSamePosition(0)).isTrue();
    }

    @Test
    @DisplayName("이동 위치 비교 테스트")
    void checkFindFasterPosition() {
        Car car = new Car("mason");
        car.moveForward(5);
        car.moveForward(5);
        assertThat(car.findFasterPosition(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름과 경주 진행 결과 반환 테스트")
    void checkMakePositionString() {
        Car car = new Car("mason");
        car.moveForward(5);
        car.moveForward(5);
        assertThat(car.makePositionString(POSITION_STAMP)).isEqualTo("mason : --");
    }
}
