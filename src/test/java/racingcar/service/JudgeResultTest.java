package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.service.JudgeResult.getWinners;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class JudgeResultTest {
    private static final int MOVING_FORWARD = Randoms.pickNumberInRange(4, 9);
    private static final int STOP = Randoms.pickNumberInRange(0, 3);

    @Test
    void 우승자_한_명_테스트() {
        List<Car> cars = setCars();
        cars.get(0).updateDistance(MOVING_FORWARD);
        for (int idx = 1; idx < cars.size(); idx++) {
            cars.get(idx).updateDistance(STOP);
        }
        List<String> winnerNames = getWinners(cars);
        assertThat(winnerNames).hasSize(1)
                .contains("abcd");
    }

    @Test
    void 우승자_두_명_이상_테스트() {
        List<Car> cars = setCars();
        cars.get(0).updateDistance(STOP);
        for (int idx = 1; idx < cars.size(); idx++) {
            cars.get(idx).updateDistance(MOVING_FORWARD);
        }
        List<String> winnerNames = getWinners(cars);
        assertThat(winnerNames).hasSize(3)
                .contains("efg", "hi", "j");
    }

    List<Car> setCars() {
        List<Car> cars = new ArrayList<>();
        List<String> names = Arrays.asList("abcd", "efg", "hi", "j");
        names.stream().forEach(name -> cars.add(new Car(name)));
        return cars;
    }
}
