package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void 자동차_이름_길이가_올바르지_않을_경우_예외가_발생한다(String name) {
        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde", "pobi!"})
    void 자동차_이름_길이가_올바를_경우_예외가_발생하지_않는다(String name) {
        // when & then
        assertDoesNotThrow(() -> new Car(name));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void 자동차의_move메서드를_호출한_만큼_전진횟수가_증가한다(int moveCount) {
        // given
        Car car = new Car("test");

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then
        assertThat(car.isSameMovedCount(moveCount)).isTrue();
    }
}