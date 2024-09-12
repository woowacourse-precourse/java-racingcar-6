package study;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.InputProcessor;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTest {

    @DisplayName("성공: 자동차이름을_입력하면_쉼표를_기준으로_분리할_수_있다")
    @Test
    void test() {
        String input = "pobi,woni";

        InputProcessor inputProcessor = new InputProcessor();
        List<Car> cars = inputProcessor.getCars(List.of(input.split(",")));
        int round = 5;
        Referee referee = new Referee();

        RacingGame racingGame = new RacingGame(cars, referee, round);
    }
}
