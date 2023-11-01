package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.intgenerator.CustomIntGenerator;
import racingcar.model.winnerstrategy.MaximumForwardStrategy;

public class RacingResultTest {

    @Test
    void 최대_전진_횟수를_가진_자동차를_우승_자동차로_결정() {
        Car winner = new Car("pobi", new CustomIntGenerator(9));
        Car nonWinner = new Car("roni", new CustomIntGenerator(3));
        Cars cars = Cars.fromCars(List.of(winner, nonWinner));

        cars.move();
        RacingResult result = new RacingResult(cars, new MaximumForwardStrategy());

        List<String> expectedWinnerName = List.of(winner.getName());
        List<String> actualWinnerName = result.getWinnerNames();
        assertThat(actualWinnerName).isEqualTo(expectedWinnerName);
    }

    @Test
    void 최대_전진_횟수를_가진_자동차가_여러대일때_공동으로_우승_자동차를_결정() {
        Car winner = new Car("pobi", new CustomIntGenerator(9));
        Car coWinner = new Car("lala", new CustomIntGenerator(6));
        Car nonWinner = new Car("roni", new CustomIntGenerator(3));
        Cars cars = Cars.fromCars(List.of(winner, coWinner, nonWinner));

        cars.move();
        RacingResult result = new RacingResult(cars, new MaximumForwardStrategy());

        List<String> expectedWinnerName = List.of(winner.getName(), coWinner.getName());
        List<String> actualWinnerName = result.getWinnerNames();
        assertThat(actualWinnerName).containsExactlyInAnyOrderElementsOf(expectedWinnerName);
    }
}
