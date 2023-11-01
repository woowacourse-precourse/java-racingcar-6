package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarListGenerator;

import java.util.List;

public class JudgementTest {

    Cars cars;
    Judgement judgement = new Judgement();
    int FORWARD_COUNT = 1;

    @Test
    void 자동차_아무도_안움직이면_공동우승() {
        String carNames = "pobi,woni";
        List<Car> carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);

        String winners = judgement.determineWinners(cars);
        String excepted = "pobi, woni";
        Assertions.assertThat(winners).isEqualTo(excepted);
    }

    @Test
    void 각_자동차_중_position_가장크면_최종우승자() {
        String carNames = "pobi,woni";
        List<Car> carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);

        cars.cars().get(0).forward(FORWARD_COUNT);
        String winners = judgement.determineWinners(cars);
        String excepted = "pobi";
        Assertions.assertThat(winners).isEqualTo(excepted);
    }

    @Test
    void 각_자동차_중_position_모두_같으면_공동우승() {
        String carNames = "pobi,woni";
        List<Car> carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);

        cars.cars().get(0).forward(FORWARD_COUNT);
        cars.cars().get(1).forward(FORWARD_COUNT);
        String winners = judgement.determineWinners(cars);
        String excepted = "pobi, woni";
        Assertions.assertThat(winners).isEqualTo(excepted);
    }
}
