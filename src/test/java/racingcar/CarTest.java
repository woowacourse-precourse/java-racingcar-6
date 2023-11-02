package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUP() {
        car = new Car("aaa");
    }

    @Test
    void move_메서드에_조건에_부합하는_값_입력시_이동() {
        car.move(5);
        int result = car.getDistance();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void move_메서드에_조건에_부합하지_않는_값_입력시_멈춤() {
        car.move(3);
        int result = car.getDistance();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void getName_매서드로_자동차_이름_반환() {
        String result = car.getName();

        assertThat(result).isEqualTo("aaa");
    }

    @Test
    void getDistance_메서드로_자동차_이동거리_반환() {
        int result = car.getDistance();

        assertThat(result).isEqualTo(0);
    }
}