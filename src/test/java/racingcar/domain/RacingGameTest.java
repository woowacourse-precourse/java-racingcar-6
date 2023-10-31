package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 우승자가_한명인_경우_출력() {
        RacingCar carA = new RacingCar("carA", 3);
        RacingCar carB = new RacingCar("carB", 1);
        List<RacingCar> cars = List.of(carA, carB);
        RacingGame game = new RacingGame(cars, 0);

        assertThat(game.getWinners()).containsExactly(carA);
    }

    @Test
    void 우승자가_두명_이상인_경우_쉼표로_구분() {
        RacingCar carA = new RacingCar("carA", 3);
        RacingCar carB = new RacingCar("carB", 3);
        List<RacingCar> cars = List.of(carA, carB);
        RacingGame game = new RacingGame(cars, 0);

        assertThat(game.getWinners()).containsExactly(carA, carB);
    }
}
