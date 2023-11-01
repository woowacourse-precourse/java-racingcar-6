package racingcar.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Winner;

class GameTest {
    private List<String> carNameList;

    @Test
    void 우승자_한_명() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        carNameList = Arrays.asList("pobi", "woni", "jun");

        car1.go();
        car1.go();
        car1.go();

        car2.go();
        car2.go();

        car3.go();

        List<Car> carsList = Arrays.asList(car1, car2);
        Winner winner = Game.findWinner(carsList);

        assertEquals(3, winner.getScore());
        assertTrue(winner.getName().contains("pobi"));
    }

    @Test
    void 우승자_여러_명() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        carNameList = Arrays.asList("pobi", "woni", "jun");

        car1.go();
        car1.go();

        car2.go();
        car2.go();

        car3.go();

        List<Car> carsList = Arrays.asList(car1, car2);
        Winner winner = Game.findWinner(carsList);

        assertEquals(2, winner.getScore());
        assertTrue(winner.getName().contains("pobi"));
        assertTrue(winner.getName().contains("woni"));
    }

}
