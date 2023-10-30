package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;

public class carTest {

    @Test
    void 자동차_테스트(){
        Car.of(0,"j");
        Car.of(0,"jo");
        Car.of(0,"joh");
        Car.of(0,"john");
        Car.of(0,"joHnN");
    }
    @Test
    void 자동차_테스트2(){
        Assertions.assertThatThrownBy(()->
                Car.of(0,"")).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                Car.of(0,"a b")).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                Car.of(0,"johnnn")).isInstanceOf(IllegalArgumentException.class);
    }
}
