package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.EachMoveResultDto;
import racingcar.domain.GameWinnerDto;
import racingcar.domain.RandomGenerator;

public class CarsTest {


    @Test
    void moveCarsAndCollectResults() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        Cars cars = new Cars(carNames, mockRandomGenerator);

        when(mockRandomGenerator.generate()).thenReturn(5);

        List<EachMoveResultDto> moveResults = cars.moveCarsAndCollectResults();

        moveResults.stream()
                .forEach(result -> assertEquals(1, result.getPosition()));
    }

    @Test
    public void FindWinnersDto() {
        List<String> carNames = Arrays.asList("car1");

        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        Cars cars = new Cars(carNames, mockRandomGenerator);

        when(mockRandomGenerator.generate()).thenReturn(5);

        List<GameWinnerDto> winnerResults = cars.findWinnersDto();

        winnerResults.stream()
                .forEach(result -> assertEquals("car1", result.getWinnerCar()));
    }

}
