package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.CarException.DUPLICATE_CAR;

public class CarsTest {
    @Test
    @DisplayName("중복된 자동차가 존재하면 게임을 진행할 수 없다")
    void throwExceptionByDuplicateCar() {
        // given
        final List<Car> candidate = List.of(
                new Car("pobi"),
                new Car("pobi"),
                new Car("pobi2")
        );

        // when - then
        assertThatThrownBy(() -> Cars.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR.message);
    }

    @Test
    @DisplayName("게임에 참여할 Cars를 관리한다")
    void success() {
        // given
        final List<Car> candidates = List.of(
                new Car("pobi1"),
                new Car("pobi2"),
                new Car("pobi3")
        );

        // when
        final Cars cars = Cars.from(candidates);

        // then
        assertThat(cars.getCars()).hasSize(candidates.size());
    }
}
