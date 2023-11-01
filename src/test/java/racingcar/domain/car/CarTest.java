package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.race.car.Car;
import racingcar.domain.race.car.Engine;

class CarTest {

    @Test
    void 자동차_이름으로_생성_테스트() {
        // given
        final String name = "pobi";

        // when
        Car car = Car.of(name, Engine.newInstance());

        // then
        Assertions.assertThat(name).isEqualTo(car.getName());
    }

}