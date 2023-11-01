package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.CarListGenerator;

import java.util.List;

class RaceTest {

    List<Car> carList;
    Cars cars;
    Race race = new Race();

    @Test
    void 레이싱_1라운드_진행() {
        String carNames = "pobi,woni";
        carList = CarListGenerator.generateCarList(carNames);
        cars = new Cars(carList);
        Car pobiCar = cars.cars().get(0);

        race.runOneRound(cars);

        Assertions.assertThat(pobiCar.getPosition()).isGreaterThanOrEqualTo(0);
    }
}
