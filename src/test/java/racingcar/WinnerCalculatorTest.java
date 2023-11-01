package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnerCalculatorTest {

    @Test
    void 공동_우승자_얻기() {
        Cars cars = new Cars("pobi,woni,jun");

        for (Car car : cars.getCars()) {
            car.move(5);
        }

        WinnerCalculator winnerCalculator = new WinnerCalculator();
        String winners = winnerCalculator.getWinners(cars);
        assertThat(winners).isEqualTo("pobi, woni, jun");
    }

    @Test
    void 우승자_한명_얻기() {
        Cars cars = new Cars("pobi,woni");
        List<Car> carList = cars.getCars();

        Car car1 = carList.get(0);

        car1.move(5);

        WinnerCalculator winnerCalculator = new WinnerCalculator();
        String winners = winnerCalculator.getWinners(cars);
        assertThat(winners).isEqualTo("pobi");
    }
}
