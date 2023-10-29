package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {


    @Test
    public void createCars_fail() {
        List<String> carNames = List.of("pobi", "pobi", "jun");
        assertThrows(IllegalArgumentException.class, () -> {
            Cars cars = new Cars(carNames);
        });
    }

}