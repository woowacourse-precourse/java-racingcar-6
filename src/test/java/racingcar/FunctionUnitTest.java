package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class FunctionUnitTest {

    Cars cars = new Cars();
    private final String RAW_CAR_NAME = "pobi,woni,jun";
    private final int TRY_COUNT = 5;

    @Test
    void 자동차_이름_저장() {
        List<Car> carList = cars.setPlayer(RAW_CAR_NAME);
        carList.forEach(car -> System.out.println(car.getCarName()));

        Assertions.assertEquals(3, carList.size());
    }

    @Test
    void 자동차_전진() {
        List<Car> carList = cars.setPlayer(RAW_CAR_NAME);
        carList = cars.raceCars(carList, TRY_COUNT);

        carList.forEach(car -> System.out.println(car.getCarName() + " " + car.getMove()));
    }

}
