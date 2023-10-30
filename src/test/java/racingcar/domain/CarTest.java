package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 5글자 이하만 가능합니다.";

    @DisplayName("정상 입력이 주어지면 새로운 Car객체가 생성되어야 한다.")
    @Test
    void getNewCarTest() {
        // given
        String name = "jason";

        // when
        Car newCar = Car.getNewCar(name);

        // then
        assertThat(newCar.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름으로 5글자 이상의 입력을 받으면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"lastcow", "123456", "포비와제이슨2", "pobi^_^"})
    void validateLengthTest(String name) {
        // when, then
        assertThatThrownBy(() -> Car.getNewCar(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("isCanMove가 true면 position이 1증가해야 한다.")
    @Test
    void moveSuccessTest() {
        // given
        boolean isCanMove = true;
        Car pobiCar = Car.getNewCar("pobi");
        int prevPosition = pobiCar.getPosition();

        // when
        pobiCar.move(isCanMove);

        // then
        assertThat(pobiCar.getPosition()).isEqualTo(prevPosition + 1);
    }

    @DisplayName("isCanMove가 false면 position은 변화가 없어야 한다.")
    @Test
    void moveFailTest() {
        // given
        boolean isCanMove = false;
        Car pobiCar = Car.getNewCar("pobi");
        int prevPosition = pobiCar.getPosition();

        // when
        pobiCar.move(isCanMove);

        // then
        assertThat(pobiCar.getPosition()).isEqualTo(prevPosition);
    }
}