package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarsGeneratorTest {
    private CarsGenerator carsGenerator;
    List<Car> carList;
    List<String> carNames;

    void preset() {
        carsGenerator = CarsGenerator.getInstance();
        carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");
    }

    @Test
    public void testGenerateCars() {
        preset();
        carList = carsGenerator.generateCars(carNames);

        assertEquals(3, carList.size());

        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
    }
}
