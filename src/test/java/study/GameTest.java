package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.GameManager;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void 우승자_판단() {

        List<Car> carListWhenMultipleWinners  = Arrays.asList(
                new Car("aaa", 1),
                new Car("bbb", 2),
                new Car("ccc", 2)
        );

        List<Car> carListWhenSingleWinner = Arrays.asList(
                new Car("aaa", 1),
                new Car("bbb", 2),
                new Car("ccc", 3)
        );

        GameManager gameManager = new GameManager();

        assertThat(gameManager.findWinnerNames(carListWhenMultipleWinners )).isEqualTo("bbb,ccc");
        assertThat(gameManager.findWinnerNames(carListWhenSingleWinner)).isEqualTo("ccc");
    }

}
