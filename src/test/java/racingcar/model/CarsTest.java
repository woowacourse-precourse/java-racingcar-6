package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
    @Test
    @DisplayName("Cars_객체_생성")
    void createCars() {
        String[] input = {"test","test2","test3"};

        Cars testCars = new Cars(input);

        assertEquals(3, testCars.getCars().size());
    }
}
