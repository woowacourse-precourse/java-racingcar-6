package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_객체_생성(){
        String name = "car1";
        Car car = new Car(name);
        assertThat(car).isNotNull();

    }
}
