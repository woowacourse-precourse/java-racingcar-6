package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    @DisplayName("이름을 입력받아 자동차 객체를 생성한다.")
    void 이름을_입력받아_자동차_객체를_생성한다() {
        // given
        var carNames = List.of("pobi", "crong", "honux");

        // when
        var cars = CarFactory.createCars(carNames);

        // then
        assertThat(cars).isInstanceOf(List.class)
                .hasOnlyElementsOfType(Car.class)
                .hasSize(3);
    }

    @Test
    @DisplayName("이름이 중복되면 예외를 발생시킨다.")
    void 이름이_중복되면_예외를_발생시킨다() {
        // given
        var carNames = List.of("pobi", "crong", "pobi");

        // when & then
        assertThatThrownBy(() -> CarFactory.createCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 중복될 수 없습니다.");
    }
}
