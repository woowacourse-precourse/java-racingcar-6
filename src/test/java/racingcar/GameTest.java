package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void getCurrentGameResult_현재_게임_결과_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
                    Game game = new Game(cars);

                    game.executeSingleCycleCarMove();

                    Map<String, Integer> result = game.getCurrentGameResult();

                    assertThat(result).containsKeys("pobi", "woni");
                    assertThat(result.get("pobi")).isEqualTo(1);
                    assertThat(result.get("woni")).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void getCurrentWinners_현재_게임_단일_우승자_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
                    Game game = new Game(cars);

                    game.executeSingleCycleCarMove();

                    List<String> winners = game.getCurrentWinners();
                    assertThat(winners).contains("pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void getCurrentWinners_현재_게임_공동_우승자_반환() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"));
                    Game game = new Game(cars);

                    game.executeSingleCycleCarMove();

                    List<String> winners = game.getCurrentWinners();
                    assertThat(winners).contains("pobi", "woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }


}
