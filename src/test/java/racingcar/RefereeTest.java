package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

class RefereeTest {

    @Test
    void getWinners_메서드로_우승자를_반환() {
        List<String> carNames = new ArrayList<>();
        carNames.add("a");
        carNames.add("b");

        List<Car> cars = Car.createCarsByNames(carNames);
        Referee referee = new Referee();

        List<Car> expectedWinners = new ArrayList<>();
        expectedWinners.add(cars.get(0));

        try (MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(4);

            cars.get(0).moveForwardOrStop();

            assertThat(referee.getWinners(cars)).isEqualTo(expectedWinners);
        }
    }

}