package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {
    private final static String WINNER = "winner";
    private final static String LOSER = "loser";

    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    @DisplayName("레이싱_우승자_리스트_확인")
    void winnerCarsSearch() {
        Cars cars = Mockito.mock(Cars.class);
        Car car1 = Mockito.mock(Car.class);
        Car car2 = Mockito.mock(Car.class);

        Mockito.when(cars.getCars())
                .thenReturn(Arrays.asList(car1, car2));
        Mockito.when(car1.getName())
                .thenReturn(WINNER);
        Mockito.when(car2.getName())
                .thenReturn(LOSER);
        Mockito.when(car1.getDistance())
                .thenReturn(2);
        Mockito.when(car2.getDistance())
                .thenReturn(1);

        String winnerName = racingCarService.getWinnerCarNames(cars)
                .get(0);

        assertThat(winnerName)
                .isEqualTo(WINNER);
    }
}