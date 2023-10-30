package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.EachGameResultDto;
import racingcar.domain.GameWinnerDto;
import racingcar.domain.RandomGenerator;

public class CarsTest {


    @Test
    void EachGameResultTest() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        Cars cars = new Cars(carNames, mockRandomGenerator);

        when(mockRandomGenerator.generate()).thenReturn(5);

        cars.moveCars();
        List<EachGameResultDto> moveResults = cars.getEachGameResult();

        moveResults.stream().forEach(result -> assertEquals(1, result.getPosition()));
    }

    @Test
    public void getWinnersTest() {
        List<String> carNames = Arrays.asList("car1");

        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        Cars cars = new Cars(carNames, mockRandomGenerator);

        when(mockRandomGenerator.generate()).thenReturn(5);

        cars.moveCars();
        List<GameWinnerDto> winnerResults = cars.getWinners();

        winnerResults.stream().forEach(result -> assertEquals("car1", result.getWinnerCar()));
    }

}
