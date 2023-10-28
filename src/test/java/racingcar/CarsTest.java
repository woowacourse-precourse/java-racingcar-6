package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarsTest {
    @Test
    void 자동차_그룹_생성() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        List<Car> carList = carNames.stream().map(Car::new).collect(Collectors.toList());
        assertDoesNotThrow(() -> new Cars(carList));
    }
}
