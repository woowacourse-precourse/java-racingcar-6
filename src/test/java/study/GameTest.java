package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.MessageProcessor;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    private List<Car> cars;
    private RandomNumberGenerator randomNumberGenerator;
    private Game game;

    @BeforeEach
    void setup() {
        cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        randomNumberGenerator = new RandomsWrapper();
    }

    @Test
    void 생성_유효한_게임() {
        game = new Game(cars, 5, new MessageProcessor());
        assertThat(game).isNotNull();
    }

    @Test
    void 생성_무효한_게임() {
        assertThatThrownBy(() -> new Game(cars, 0, new MessageProcessor())).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승자_확인() {
        game = new Game(cars, 5, new MessageProcessor());
        game.play();

        assertThat(game.getWinners()).containsExactly("car1", "car2", "car3");
    }

}
