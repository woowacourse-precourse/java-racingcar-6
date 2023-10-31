package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @Test
    void createCars() {
        List<String> carNames = new ArrayList<>();
        carNames.add("jane");
        carNames.add("bam");

        List<Car> cars = CarFactory.createCars(carNames);
        String carName1 = cars.get(0).getName();
        String carName2 = cars.get(1).getName();
        int carsLength = cars.size();

        assertThat(carsLength).isEqualTo(2);
        assertThat(carName1).isEqualTo("jane");
        assertThat(carName2).isEqualTo("bam");
    }

}
