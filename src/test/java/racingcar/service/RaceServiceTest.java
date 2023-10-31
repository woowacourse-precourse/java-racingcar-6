package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        raceService = new RaceService();
    }

    @Test
    public void executeRaceTest() {
        // Given
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        List<Car> cars = Arrays.asList(car1, car2);
        Race race = new Race(cars, 5);
        RaceService raceService = new RaceService();

        // When
        raceService.executeRace(race);

        // Then
        verify(car1, times(5)).move(anyBoolean());
        verify(car2, times(5)).move(anyBoolean());
    }

    @Test
    void findWinnersTest() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(true);
        List<Car> cars = Arrays.asList(car1, car2);

        Race race = new Race(cars, 1);

        List<Car> winners = raceService.findWinners(race);

        assertEquals(1, winners.size());
        assertEquals(car1, winners.get(0));
    }

}
