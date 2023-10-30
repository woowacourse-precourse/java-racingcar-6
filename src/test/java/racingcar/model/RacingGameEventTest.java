package racingcar.model;

import java.util.List;
import java.util.Map.Entry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Car;

class RacingGameEventTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    public void createRacingCarTest() {
        String[] cars = {"pobi", "woni", "jun"};
        RacingGameEvent racingGameEvent = new RacingGameEvent(cars);
        Assertions.assertThat(racingGameEvent.getPositionHistory().size()).isEqualTo(3);
    }

    @DisplayName("이동 할 경우 테스트")
    @Test
    public void startEventMoveTest() {
        String[] cars = {"pobi"};
        int attempt = 3;
        RacingGameEvent racingGameEvent = new RacingGameEvent(cars);
        for (int i = 0; i < attempt; i++) {
            for (Entry<Car, List<Integer>> value : racingGameEvent.getPositionHistory().entrySet()) {
                Car carName = value.getKey();
                List<Integer> position = value.getValue();
                position.add(carName.moveForward(true));
            }
        }
        Assertions.assertThat(racingGameEvent.getPositionHistory().values().toArray())
                .isEqualTo(List.of(List.of(0, 1, 2)).toArray());
    }

    @DisplayName("이동하지 않을 경우 테스트")
    @Test
    public void startEventStopTest() {
        String[] cars = {"pobi"};
        int attempt = 3;
        RacingGameEvent racingGameEvent = new RacingGameEvent(cars);
        for (int i = 0; i < attempt; i++) {
            for (Entry<Car, List<Integer>> value : racingGameEvent.getPositionHistory().entrySet()) {
                Car carName = value.getKey();
                List<Integer> position = value.getValue();
                position.add(carName.moveForward(false));
            }
        }
        Assertions.assertThat(racingGameEvent.getPositionHistory().values().toArray())
                .isEqualTo(List.of(List.of(0, 0, 0)).toArray());
    }
}