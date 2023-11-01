package racingcar.domain.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.race.car.Car;

class CarFactoryTest {

    @Test
    void Car_Factory_다른_인스턴스_생성_테스트() {
        // given
        final String NAME = "pobi";

        // when
        Car car1 = CarFactory.newIntanceCar(NAME);
        Car car2 = CarFactory.newIntanceCar(NAME);

        // then
        Assertions.assertThat(car1)
                .isNotSameAs(car2);
    }

}