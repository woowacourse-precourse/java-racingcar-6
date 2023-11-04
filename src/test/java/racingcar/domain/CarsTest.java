package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setUp() {
        cars = new Cars();
    }

    @Test
    public void 자동차_이름_주입() {
        List<String> carNames = Arrays.asList("차1", "차2", "차3");

        cars.insertCarsNames(carNames);

        assertEquals(3, cars.getCars().size());
    }

    @Test
    public void 우승자_찾기() {
        List<Car> carList = Arrays.asList(
                new Car("차1", 3),
                new Car("차2", 5),
                new Car("차3", 3)
        );
        cars.getCars().addAll(carList);

        List<Car> winners = cars.findWinners();

        assertEquals("차2", winners.get(0).getName());
    }
}
