package racingcar.domain;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void cars_생성자_테스ㅌ() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        assertNotNull(cars);

        List<String> carNames = cars.getCars().stream().map(Car::getName).collect(toList());
        assertEquals(names, carNames);
    }
}
