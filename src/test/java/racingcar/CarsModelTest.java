package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsModelTest {
    @Test
    void 자동차_이름과_결과를_String_리스트로_리턴() {
        List<Car> carList = new ArrayList<>();
        List<String> carNameList = new ArrayList<>(Arrays.asList("abc", "def"));

        for(String name: carNameList) {
            Car car = new StubCar(name);
            carList.add(car);
        }
        Cars cars = new Cars(carList);

        for (int i=1; i<=5; i++) {
            cars.moveCars();
        }

        assertThat(cars.getRoundResult()).containsExactly("abc : -----", "def : -----");
    }
}
