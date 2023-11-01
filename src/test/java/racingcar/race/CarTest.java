package racingcar.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.PickRandomNumber;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new PickRandomNumber());
    }

    @Test
    void testCarsDistanceDataInitialEmpty() {
        Map<String, String> carsDistanceData = car.getCarsDistanceData();
        Assertions.assertThat(carsDistanceData).isEmpty();
    }

    @Test
    void testRacingStarts() {
        List<String> carNames = new ArrayList<>();
        carNames.add("Car1");
        carNames.add("Car2");
        carNames.add("Car3");

        car.racingStarts(carNames);

        Map<String, String> carsDistanceData = car.getCarsDistanceData();
        Assertions.assertThat(carsDistanceData).hasSize(carNames.size());

        for (String carName : carNames) {
            String distance = carsDistanceData.get(carName);
            Assertions.assertThat(distance).matches("-*"); // 문자열이 '-' 문자로만 구성되어야 함
        }
    }
}

