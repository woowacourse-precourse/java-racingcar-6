package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.Domain.Cars;
import racingcar.Domain.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {
    @Test
    @DisplayName("가장 앞에 있는 자동차가 우승자가 맞는지")
    public void winnerShouldHaveBiggestPosition() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(Car.of("juhi"));
        carsList.add(Car.of("tony"));
        Cars cars = Cars.of(carsList);

        List<Integer> moveValues = new ArrayList<>();
        moveValues.add(3);
        moveValues.add(5);
        cars.move(moveValues);

        Result result = Result.of(cars);
        List<String> winners = result.getWinner();
        assertEquals(winners.get(0), "tony");
    }
}
