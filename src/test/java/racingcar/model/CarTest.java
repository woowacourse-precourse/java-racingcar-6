package racingcar.model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_이름이_올바르게_들어가는지() {

        String name = "자동차";
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 자동차_생성시_처음의_위치() {

        String name = "자동차";
        Car car = new Car(name);

        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    void 전진시_자동차의_위치이동() {

        Car car = new Car("자동차");
        int moveNumber = 4;

        for(int i = 0; i < moveNumber; i++) {
            car.forwardLocation();
        }

        assertThat(car.getLocation()).isEqualTo(moveNumber);
    }
}
