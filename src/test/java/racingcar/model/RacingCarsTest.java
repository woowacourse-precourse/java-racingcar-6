package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameDuplicateException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @Test
    void 자동차_이름이_중복될_경우_예외() {
        // given
        List<Car> input = new ArrayList<>();
        input.add(new Car(new Name("july"), new Distance()));
        input.add(new Car(new Name("july"), new Distance()));


        // when & then
        assertThatThrownBy(() -> new RacingCars(input))
                .isInstanceOf(CarNameDuplicateException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}