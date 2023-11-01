package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private Judgment judgment;
    private NumberGenerator generator;

    @BeforeEach
    void init() {
        car1 = new Car("ccc");
        car2 = new Car("Car2");
        car3 = new Car("Car3");
        judgment = new Judgment();
        generator = new NumberGenerator();
    }

    @Test
    void test_validateNameLength() {
        assertThatThrownBy(() -> new Car("fiveName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_currentLocation() {
        assertThat(car1.currentLocation()).isEqualTo("ccc : ");
    }

    @Test
    void test_forward() {
        car1.forward(judgment, 5);
        assertThat(car1.currentLocation()).isEqualTo("ccc : -");
    }

    @Test
    public void test_IsEqualDistance_One_winner() {
        List<Car> carList = List.of(car1, car2, car3);
        car1.forward(judgment, 5);

        StringBuilder result = car1.isEqualDistance(carList);
        assertThat(result.toString()).isEqualTo("ccc");
    }

    @Test
    public void test_IsEqualDistance_Two_winner() {
        List<Car> carList = List.of(car1, car2, car3);
        car1.forward(judgment, 5);
        car2.forward(judgment, 5);

        StringBuilder result = car1.isEqualDistance(carList);
        assertThat(result.toString()).isEqualTo("ccc, Car2");
    }

    @Test
    public void test_IsEqualDistance_Three_winner() {
        List<Car> carList = List.of(car1, car2, car3);
        car1.forward(judgment, 5);
        car2.forward(judgment, 5);
        car3.forward(judgment, 5);

        StringBuilder result = car1.isEqualDistance(carList);
        assertThat(result.toString()).isEqualTo("ccc, Car2, Car3");
    }
}