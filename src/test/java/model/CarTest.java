package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void Car_인스턴스_생성() {
        String name = "자동차";
        Car car = new Car(name);

        assertThat(car.getClass()).isEqualTo(Car.class);
    }

    @Test
    public void Car_생성_실패() {
        String name = "abcded";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 전진_성공() {
        Car car = new Car("pobi");
        car.tryMove(4);
        assertThat(car.getNowPlace()).isEqualTo("-");
    }

    @Test
    public void 전진_실패() {
        Car car = new Car("pobi");
        car.tryMove(3);
        assertThat(car.getNowPlace()).isEqualTo("");
    }

}
