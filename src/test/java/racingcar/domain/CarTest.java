package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.driver.Driver;
import racingcar.mock.FalseDriver;
import racingcar.mock.TrueDriver;
import racingcar.vo.CarName;

class CarTest {
    private final Driver trueDriver = new TrueDriver();
    private final Driver falseDriver = new FalseDriver();


    @Test
    void 이동시_위치값이_1증가한다() {
        // given
        Car car = new Car(new CarName("pobi"), trueDriver);
        // when
        car.move();
        // then
        Assertions.assertThat(car.toDTO().getPosition()).isEqualTo(1);
    }

    @Test
    void 정지시_위치값이_증가하지_않는다() {
        // given
        Car car = new Car(new CarName("pobi"), falseDriver);
        // when
        car.move();
        // then
        Assertions.assertThat(car.toDTO().getPosition()).isEqualTo(0);
    }
}