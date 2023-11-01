package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Umpire;

public class GameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final String[] names = new String[]{"pobi", "woni", "jun"};

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받기() {
        Cars cars = new Cars();
        String input = "pobi,woni,jun";
        command(input);

        List<String> carNames = cars.inputCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 시도_횟수_입력받아_저장하기() {
        Attempt attempt = new Attempt();
        command("5");

        assertThatCode(() -> attempt.saveAttemptNumber()).doesNotThrowAnyException();
    }

    @Test
    void 우승자_찾기() {
        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());

        assertRandomNumberInRangeTest(
                () -> {
                    Umpire umpire = new Umpire(cars);
                    Game game = new Game(cars, 1);
                    game.play();
                    String winnerResult = umpire.findWinner();

                    assertEquals("pobi, woni", winnerResult);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 라운드_결과_가져오기() {
        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());

        assertRandomNumberInRangeTest(
                () -> {
                    Game game = new Game(cars, 1);
                    game.start();
                    List<String> roundResult = game.getRoundResult();

                    assertEquals("pobi : -,woni : ,jun : -", String.join(",", roundResult));
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
