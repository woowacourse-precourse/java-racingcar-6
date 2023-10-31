package study;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.InputProcessor;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;

public class RacingGameTest {

    @Test
    void 자동차이름을_입력하면_쉼표를_기준으로_분리할_수_있다() {
        String input = "pobi,woni";

        InputProcessor inputProcessor = new InputProcessor();
        List<Car> cars = inputProcessor.getCars(List.of(input.split(",")));
        Integer round = 5;
        Referee referee = new Referee();

        RacingGame racingGame = new RacingGame(cars, referee, round);
    }
}
