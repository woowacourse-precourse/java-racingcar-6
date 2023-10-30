package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Car;

class RacingGameEventTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    public void createRacingCarTest() {
        String[] cars = {"pobi", "woni", "jun"};
        RacingGameEvent racingGameEvent = new RacingGameEvent(cars);
        assertThat(racingGameEvent.getPositionHistory().size()).isEqualTo(3);
    }

    @DisplayName("자동차가 이동 할 경우 테스트")
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
        assertThat(racingGameEvent.getPositionHistory().values().toArray())
                .isEqualTo(List.of(List.of(1, 2, 3)).toArray());
    }

    @DisplayName("자동차가 이동하지 않을 경우 테스트")
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
        assertThat(racingGameEvent.getPositionHistory().values().toArray())
                .isEqualTo(List.of(List.of(0, 0, 0)).toArray());
    }

    @DisplayName("우승자 이름을 저장할 getWinnerNames 테스트")
    @Test
    public void getWinnerNamesTest() {
        String[] cars = {"pobi", "jun", "jiu"};
        RacingGameEvent racingGameEvent = new RacingGameEvent(cars);
        int attempt = 3;
        for (int i = 0; i < attempt; i++) {
            for (Entry<Car, List<Integer>> value : racingGameEvent.getPositionHistory().entrySet()) {
                Car carName = value.getKey();
                List<Integer> position = value.getValue();
                position.add(carName.moveForward(true));
            }
        }

        List<String> winnerNames = racingGameEvent.getWinnerNames(racingGameEvent.getPositionHistory());
        assertThat(winnerNames.size()).isEqualTo(3);
    }
}