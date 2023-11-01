package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    @Test
    public void testGetCars() {
        String names = "pobi,jun,yeon";
        Cars cars = new Cars(names);
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
    }

    @Test
    public void testWinners() {
        String names = "pobi,jun,yeon";
        Cars cars = new Cars(names);
        Winners winners = cars.getWinners();
        assertThat(winners).isNotNull();
    }

    @Test
    public void testDuplicatedNames() {
        String names = "pobi,jun,pobi";
        assertThrows(IllegalArgumentException.class, () -> {
            new Cars(names);
        });
    }
}
