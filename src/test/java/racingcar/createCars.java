package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class createCars {

        @Test
    public void testGetCarAtIndex() {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("hong"));
        carList.add(new Car("min"));
        Cars cars = new Cars(carList);

        Car car = cars.get(1);

        assertEquals("hong", car.getName());
    }

    @Test
    public void testToString() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("hong"));
        carList.add(new Car("min"));
        carList.add(new Car("pobi"));
        Cars cars = new Cars(carList);

        String carsAsString = cars.toString();

        assertEquals("[hong, min, pobi]", carsAsString);
    }

    @Test
    public void testSize() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("hong"));
        carList.add(new Car("min"));
        Cars cars = new Cars(carList);

        int size = cars.size();

        assertEquals(3, size);
    }

}
