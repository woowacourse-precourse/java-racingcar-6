package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.model.Race;

import java.util.List;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @Test
    void 실행_결과를_출력한다() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        Race race = new Race(List.of(pobi, woni, jun), 1);
        race.play();

        outputView.printExecutionResultMessage(race.getExecutionResults());
    }

    @Test
    void 우승자_목록을_출력한다() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        Race race = new Race(List.of(pobi, woni, jun), 1);
        race.play();

        outputView.printWinnerResultMessage(race);
    }
}