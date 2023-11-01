package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarsGeneratorTest {
    String name1 = "pobi";
    String name2 = "woni";
    String name3 = "jun";
    Integer numberOfCars = 3;
    private CarsGenerator carsGenerator;
    List<Car> carList;
    List<String> carNames;

    void beforeEach() {
        carsGenerator = CarsGenerator.getInstance();
        carNames = new ArrayList<>();
    }

    @Test
    public void testGenerateCars() {
        beforeEach();
        carNames.add(name1);
        carNames.add(name2);
        carNames.add(name3);

        carList = carsGenerator.generateCars(carNames);

        assertEquals(numberOfCars, carList.size());

        assertEquals(name1, carList.get(0).getName());
        assertEquals(name2, carList.get(1).getName());
        assertEquals(name3, carList.get(2).getName());
    }
}
