package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameTest {
    private CarRacingGame carRacingGame = new CarRacingGame();

    @Test
    void getMaxScore_최대점수얻기_오류없음() {
        List<Car> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(new Car(String.valueOf('A' + i)));
        }
        int max = carRacingGame.getMaxScore(items);
        Assertions.assertThat(max).isEqualTo(0);
    }

    @Test
    void runningProcess_실행_오류없음() {
        List<Car> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(new Car(String.valueOf('A' + i)));
        }
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(
                () -> carRacingGame.runningProcess(items, 5));
    }

    @Test
    void getWinners_실행_오류없음() {
        List<Car> items = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(new Car(String.valueOf('A' + i)));
            expected.add(String.valueOf('A'+i));
        }
        List<String> ret = carRacingGame.getWinners(items, 0);
        Assertions.assertThat(ret).isEqualTo(expected);
    }
}
