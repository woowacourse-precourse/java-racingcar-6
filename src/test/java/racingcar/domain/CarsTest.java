package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarsTest {
    private Cars cars;
    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 1;

    @BeforeEach
    void init() {
        car1 = Car.create("car1");
        car2 = Car.create("car2");
        car3 = Car.create("car3");
        car4 = Car.create("car4");

        List<Car> carList = new ArrayList<>(Arrays.asList(car1, car2, car3, car4));
        cars = Cars.create(carList);
    }

    @DisplayName("determineWinner() 테스트 - 우승자가 1명인 경우")
    @Test
    void determineWinners1() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(MOVING_FORWARD, STOP, STOP, STOP);
            cars.play();
        }
        List<String> winners = cars.determineWinners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).containsExactly("car1");

        List<List<Integer>> scoreList = cars.provideAllCumulativeScoreList();
        assertThat(scoreList.get(0)).isEqualTo(Arrays.asList(1));
        assertThat(scoreList.get(1)).isEqualTo(Arrays.asList(0));
    }

    @DisplayName("determineWinner() 테스트 - 우승자가 2명인 경우")
    @Test
    void determineWinners2() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP, STOP);
            cars.play();
        }
        List<String> winners = cars.determineWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsExactly("car1", "car2");
    }

    @DisplayName("determineWinner() 테스트 - 게임 2번 진행 후 우승자가 2명인 경우")
    @Test
    void determineWinners3() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP, STOP);
            cars.play();
            cars.play();
        }
        List<String> winners = cars.determineWinners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsExactly("car1", "car2");

        List<List<Integer>> scoreList = cars.provideAllCumulativeScoreList();
        List<Integer> cumulativeScoreList = car1.getCumulativeScoreList();
        assertThat(cumulativeScoreList.size()).isEqualTo(2);
        assertThat(scoreList.get(0)).isEqualTo(Arrays.asList(1, 1));
        assertThat(scoreList.get(1)).isEqualTo(Arrays.asList(1, 1));
        assertThat(scoreList.get(2)).isEqualTo(Arrays.asList(0, 0));
        assertThat(scoreList.get(3)).isEqualTo(Arrays.asList(0, 0));
    }
}