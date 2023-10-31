package racingcar.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RefereeTest {

    @DisplayName("자동차 경주 승자의 이름을 반환한다.")
    @Test
    void getWinnerCarName() {
        Cars cars = Mockito.mock(Cars.class);

        List<Car> carList = Arrays.asList(
                new Car("pobi"),
                new Car("jun"),
                new Car("seok")
        );

        when(cars.getCarsList()).thenReturn(carList);

        Referee referee = new Referee();
        String actual = referee.getWinnersCarName(cars);

        Assertions.assertAll(
                () -> Assertions.assertEquals("pobi, jun, seok", actual)
        );
    }
}
