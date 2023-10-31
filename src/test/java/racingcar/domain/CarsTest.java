package racingcar.domain;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void cars_생성자_테스ㅌ() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        assertNotNull(cars);

        List<String> carNames = cars.getCars().stream().map(Car::getName).collect(toList());
        assertEquals(names, carNames);
    }

    @Test
    void 최종_우승자_테스트() {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        Car car3 = mock(Car.class);

        when(car1.getMoveDistance()).thenReturn(5);
        when(car2.getMoveDistance()).thenReturn(3);
        when(car3.getMoveDistance()).thenReturn(5);

        when(car1.getName()).thenReturn("pobi");
        when(car2.getName()).thenReturn("woni");
        when(car3.getName()).thenReturn("jun");

        Cars cars = new Cars(Arrays.asList("pobi", "woni", "jun"));

        List<Car> carList = cars.getCars();
        carList.set(0, car1);
        carList.set(1, car2);
        carList.set(2, car3);

        String result = cars.award();
        assertEquals("pobi, jun", result);
    }
}
