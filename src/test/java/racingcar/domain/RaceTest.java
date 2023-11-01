package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RaceTest {

    @Test
    void 게임_진행_테스트() {

        List<Car> cars = Arrays.asList(
                new Car("m"),
                new Car("o"),
                new Car("r")
        );
        int trialNum = 5;
        Race race = new Race(cars, trialNum);
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {

            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4, 1, 7, 4, 8, 2, 6, 8, 3, 9, 2, 1, 2, 6, 9);
            race.playRaceGame();
        }
        assertEquals(cars.get(0).getPosition(), 4);
        assertEquals(cars.get(1).getPosition(), 3);
        assertEquals(cars.get(2).getPosition(), 2);
    }
}