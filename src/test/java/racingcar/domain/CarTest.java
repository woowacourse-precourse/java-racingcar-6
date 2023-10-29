package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car1;

    @BeforeEach
    void init() {
        car1 = new Car("ccc");
    }

    @Test
    void forward() {
        car1.forward();
        assertThat(car1.currentLocation()).isEqualTo("ccc : -");
    }

    @Test
    void currentLocation() {
        car1.forward();
        car1.forward();
        car1.forward();
        assertThat(car1.currentLocation()).isEqualTo("ccc : ---");
    }

    @Test
    public void testIsEqualDistance_One_winner() {
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        List<Car> carList = List.of(car1, car2, car3);
        car1.forward();

        StringBuilder result = car1.isEqualDistance(carList);
        assertThat(result.toString()).isEqualTo("ccc");
    }

    @Test
    public void testIsEqualDistance_Two_winner() {
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        List<Car> carList = List.of(car1, car2, car3);
        car1.forward();
        car2.forward();

        StringBuilder result = car1.isEqualDistance(carList);
        assertThat(result.toString()).isEqualTo("ccc, Car2");
    }

    @Test
    public void testIsEqualDistance_Three_winner() {
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        List<Car> carList = List.of(car1, car2, car3);
        car1.forward();
        car2.forward();
        car3.forward();

        StringBuilder result = car1.isEqualDistance(carList);
        assertThat(result.toString()).isEqualTo("ccc, Car2, Car3");
    }
}