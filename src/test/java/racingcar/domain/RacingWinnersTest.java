package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;

public class RacingWinnersTest {
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        // 테스트를 위해 Car 객체들을 초기화
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        cars = Car.createCarList(names);

        // 각 차의 거리를 설정 (car1: 3, car2: 4, car3: 4)
        cars.get(0).move(() -> true);
        cars.get(0).move(() -> true);
        cars.get(0).move(() -> true);

        cars.get(1).move(() -> true);
        cars.get(1).move(() -> true);
        cars.get(1).move(() -> true);
        cars.get(1).move(() -> true);

        cars.get(2).move(() -> true);
        cars.get(2).move(() -> true);
        cars.get(2).move(() -> true);
        cars.get(2).move(() -> true);
    }

    @Test
    public void testGetWinnerNames() {
        RacingWinners racingWinners = RacingWinners.of(cars);

        List<String> winnerNames = racingWinners.getWinnerNames();
        List<String> expectedWinnerNames = Arrays.asList("pobi", "lefthand");

        assertEquals(expectedWinnerNames, winnerNames);
    }
}
