package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    @Test
    void testGameMatch() {
        Game game = new Game();
        game.CarList = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        game.CarList.add(car1);
        game.CarList.add(car2);
        game.totalMove = 1;
        game.Match();
        assertThat(car1.moveCnt).isGreaterThanOrEqualTo(0);
        assertThat(car2.moveCnt).isGreaterThanOrEqualTo(0);
    }

    @Test
    void testGameWinner() {
        Game game = new Game();
        game.CarList = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        game.CarList.add(car1);
        game.CarList.add(car2);
        car1.moveCnt = 3;
        car2.moveCnt = 5;
        String result = game.Winner();
        assertThat(result).isEqualTo("최종 우승자 : Car2"); }

}
