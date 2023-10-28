package racingcar.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void car_생성자_테스트() {
        String name = "pobyy";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void car_생성자_이름_null_대입시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }

    @Test
    void car_생성자_이름_길이_5_초과시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("abcdefg");
        });
    }

    @Test
    void car_생성자_이름_길이_0_이하시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void car_생성자_이름_공백시_예외_반환() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("   ");
        });
    }

    @Test
    void move_메서드_테스트() {
        Car car = new Car("pobi");
        for (int i = 0; i < 50000; i++) {
            car.move();
        }
        assertThat(car.getForwardCount()).isGreaterThan(0);
    }

    @Test
    void getCurrentStatusString_메서드_테스트() {
        Car car = new Car("pobi");
        for (int i = 0; i < 50000; i++) {
            car.move();
        }
        assertThat(car.getCurrentStatusString()).contains("pobi", "-");
    }
}
