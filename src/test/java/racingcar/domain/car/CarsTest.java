package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.NameRule.NAME_DUPLICATED;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 중복_이름을_입력할_경우_예외_반환() {
        Car car1 = new Car(new Name("first"));
        Car car2 = new Car(new Name("first"));
        assertThatThrownBy(() -> Cars.asCars(List.of(car1, car2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_DUPLICATED);
    }
}