package racingcar.domain;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        RandomNumberGenerator randomNumberGenerator = Mockito.mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generateRandomNumber()).thenReturn(1, 2, 3);

        race = new Race(cars, 3);

    }

    @Test
    void printRaceResult() {
        race.printRaceResult();
    }
}