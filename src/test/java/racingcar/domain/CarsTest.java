package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarsTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));
    }

    @Test
    void getWinners_우승자_검증에_성공한다() {
        assertDoesNotThrow(() -> Cars.getWinners(cars, 3));
    }

    @ParameterizedTest
    @CsvSource({"-1, 2", "3, -1", "-1, -1"})
    void testSomeMethod(int maxPosition, int numCars) {
        assertThrows(IllegalArgumentException.class, () -> Cars.getWinners(cars, numCars));
    }
}


