package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    void testCreateCars() {
        System.setIn(createUserInput("pobi,woni,jun"));

        cars.createCars();

        assertEquals(3, cars.getCars().size());
        assertEquals("pobi", cars.getCars().get(0).getName());
        assertEquals("woni", cars.getCars().get(1).getName());
        assertEquals("jun", cars.getCars().get(2).getName());
    }

    @Test
    void testMove() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        cars.getCars().add(car1);
        cars.getCars().add(car2);

        cars.move();

        assertNotEquals(0, car1.getPosition());
        assertNotEquals(0, car2.getPosition());
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
