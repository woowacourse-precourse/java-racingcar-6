package study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class GameResultTest {

    @Test
    void 단독_우승_출력() {
        List<Car> winners = new ArrayList<>();

        Car car1 = new Car("pobi");
        winners.add(car1);

        assertEquals("최종 우승자 : pobi", OutputView.finalWinnerString(winners));
    }

    @Test
    void 공동_우승_출력() {
        List<Car> winners = new ArrayList<>();

        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");
        winners.add(car1);
        winners.add(car2);

        assertEquals("최종 우승자 : pobi, jun", OutputView.finalWinnerString(winners));
    }
}
