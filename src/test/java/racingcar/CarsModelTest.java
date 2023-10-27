package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsModelTest {
    Cars cars;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void init() {
        List<Car> carList = new ArrayList<>();
        car1 = mock(Car.class);
        car2 = mock(Car.class);
        car3 = mock(Car.class);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        cars = new Cars(carList);
    }

    @Test
    void 자동차_이름과_결과를_String_리스트로_리턴() {
        when(car1.getNameWithPosition()).thenReturn("car1 : -----");
        when(car2.getNameWithPosition()).thenReturn("car2 : ---");
        when(car3.getNameWithPosition()).thenReturn("car3 : ----");

        assertThat(cars.getRoundResult()).containsExactly("car1 : -----", "car2 : ---", "car3 : ----");
    }
}
