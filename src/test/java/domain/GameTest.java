package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Movement;

public class GameTest {
    private Cars cars;
    private Attempt attempt;
    private Movement movement;

    @BeforeEach
    public void setUp() {
        cars = new Cars();
        attempt = new Attempt();
        movement = new Movement();
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받기() {
        String input = "pobi,woni,jun";
        command(input);

        List<String> carNames = cars.inputCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 시도_횟수_입력받아_저장하기() {
        command("5");

        assertThatCode(() -> attempt.saveAttemptNumber()).doesNotThrowAnyException();
    }

    @Test
    void 우승자_찾기() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        Game game = new Game(cars, 5);

        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        cars.get(0).move();
        cars.get(1).move();

        String winnerResult = game.listWinner();

        assertEquals("pobi, woni", winnerResult);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
