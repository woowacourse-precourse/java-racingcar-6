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
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        Cars cars = new Cars(carList);

        Car car = cars.get(1);

        assertEquals("Car2", car.getName());
    }

    @Test
    public void testToString() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        Cars cars = new Cars(carList);

        String carsAsString = cars.toString();

        assertTrue(carsAsString.contains("[Car1, Car2, Car3]"));
    }

    @Test
    public void testSize() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        Cars cars = new Cars(carList);

        int size = cars.size();

        assertEquals(3, size);
    }

}
