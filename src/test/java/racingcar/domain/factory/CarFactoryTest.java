package racingcar.domain.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomMoveEngine;

@SuppressWarnings("NonAsciiCharacters")
class CarFactoryTest {
    private static final CarFactory carFactory = new CarFactory(new RandomMoveEngine());

    @Test
    void 이름으로_자동차를_생성하면_기본_위치를_가진다() {
        Car car = carFactory.create("car");

        assertThat(car.getPosition()).isZero();
    }
}
