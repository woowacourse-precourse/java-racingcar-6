package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RaceServiceTest{

    @Mock
    private RandomNumberService randomNumberService;

    @InjectMocks
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeRoundTest() {
        // given
        RandomNumberService randomNumberService = mock(RandomNumberService.class);
        when(randomNumberService.generateRandomNumber()).thenReturn(4);

        RaceService raceService = new RaceService(randomNumberService);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        Race race = new Race(cars, 5);

        // when
        raceService.executeRound(race);
        int actualPosition = cars.get(0).getPosition();

        // then
        assertEquals(1, actualPosition, "자동차는 랜덤 생성 수가 4여야 전진합니다.");
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
