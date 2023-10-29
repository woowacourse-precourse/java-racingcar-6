package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_객체_생성() {

        //given
        String name = "car1";

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getName()).isEqualTo("car1");
        assertThat(car.getMove()).isEqualTo(0);
    }

    @Test
    void 전진() {

        //given
        String name = "car";
        Car car = new Car(name);

        //when
        car.forward();

        //then
        assertThat(car.getMove()).isEqualTo(1);
    }

    @Test
    void 전진_2번() {
        //given
        String name = "car";
        Car car = new Car(name);

        //when
        for (int i = 0; i < 2; i++) {
            car.forward();
        }

        //then
        assertThat(car.getMove()).isEqualTo(2);
    }
}
