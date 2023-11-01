package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void CAR_객체생성(){
        Car car = new Car("Sanghee");
        assertThat(car.toString()).contains("Sanghee : ");
    }

    @Test
    void CAR_움직이기(){
        Car car = new Car("Sanghee");
        car.move();
        assertThat(car.toString()).contains("Sanghee : -");
    }
}
