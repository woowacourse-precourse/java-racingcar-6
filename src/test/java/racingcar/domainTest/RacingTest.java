package racingcar.domainTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.Car;
import racingcar.domain.Race;
import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RacingTest {
    @InjectMocks
    private Race race;

    @Mock
    private NumberGenerator numberGenerator;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void 이동_횟수만큼_경주_진행() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("tayo"));
        cars.add(new Car("gani"));

        int moveCount = 5;
        race.racing(cars, moveCount);
        numberGenerator = mock(NumberGenerator.class);
        verify(numberGenerator, times(5));
    }

    @Test
    void 랜덤번호가_4_이상인_경우_전진() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("tayo"));

        when(numberGenerator.createRandomNumber()).thenReturn(1, 2, 3, 4, 5);
        race.racing(cars, 5);
        for (Car car : cars) {
            assertEquals(2, car.getStatus().length());
        }
    }
}