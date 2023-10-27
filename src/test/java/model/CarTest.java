package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void Car_인스턴스_생성() {
        String name = "자동차";
        Car car = new Car(name);

        assertThat(car.getClass()).isEqualTo(Car.class);
    }

}
