package racingcar.utilTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.Car;
import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGeneratorTest {
    @Mock
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void 자동차_개수만큼_랜덤번호_생성() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("tayo"));
        cars.add(new Car("gani"));

        List<Integer> randomNumbers = new ArrayList<>();
        int actualCount = 0;
        for (Car car : cars) {
            randomNumbers.add(numberGenerator.createRandomNumber());
            actualCount++;
        }

        int expectedCount = cars.size();
        assertEquals(expectedCount, actualCount);
    }
}
