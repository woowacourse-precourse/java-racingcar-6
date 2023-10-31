package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {


    @Test
    void 이름이_5자_이하인_정상객체_생성(){
        Car car = new Car("pobi");

        String carName = car.getCarName();

        Assertions.assertThat(carName.length()).isEqualTo(4);
    }

    @Test
    void 이름이_5자_초과인_이상객체_생성() {
        Assertions.assertThatThrownBy(() -> new Car("CapPobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Limit length 5");
    }

    @Test
    void 객체의_거리_증가() {
        Car car = new Car("pobi");
        car.forward();

        Assertions.assertThat(car.getCarDistance()).isEqualTo(1);
    }
}