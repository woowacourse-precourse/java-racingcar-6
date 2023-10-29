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
    public void Car_생성_실패(){
        String name="abcded";
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Car_한_칸_전진() {
        String name = "자동차";
        String one_place = "-";
        Car car = new Car(name);
        car.move_forward(one_place);

        assertThat(car.getNowPlace()).isEqualTo("-");
    }

    @Test
    public void Car_한_칸_전진_후_한_칸_더_전진() {
        String name = "자동차";
        String one_place = "-";
        Car car = new Car(name);
        car.move_forward(one_place);
        car.move_forward(one_place);

        assertThat(car.getNowPlace()).isEqualTo("--");
    }
}
