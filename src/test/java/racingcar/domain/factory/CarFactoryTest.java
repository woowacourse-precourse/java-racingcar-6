package racingcar.domain.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomMoveEngine;

@SuppressWarnings("NonAsciiCharacters")
class CarFactoryTest {
    private static final CarFactory carFactory = new CarFactory(new RandomMoveEngine());

    @Test
    void 이름으로_자동차를_생성할_수_있다() {
        Car car = carFactory.create("car");

        assertThat(car.getPosition()).isZero();
    }
}
