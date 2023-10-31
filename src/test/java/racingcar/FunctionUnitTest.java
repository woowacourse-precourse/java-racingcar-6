package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class FunctionUnitTest {

    @Test
    void 자동차_이름_저장() {
        Cars cars = new Cars();
        String rawCarName = "pobi,woni";

        List<Car> carList = cars.setPlayer(rawCarName);

        carList.stream().forEach(car -> System.out.println(car.getCarName()));

        Assertions.assertEquals(2, carList.size());
    }

}
