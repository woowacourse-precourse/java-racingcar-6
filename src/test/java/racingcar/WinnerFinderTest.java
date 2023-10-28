package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerFinderTest {

    @Test
    void 최대이동횟수_찾기() {
        Car car1 = new Car("pobi", new TestNumberGenerator(4));
        Car car2 = new Car("woni", new TestNumberGenerator(5));
        Car car3 = new Car("jun", new TestNumberGenerator(3));
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Game game = new Game(cars, 5);
        game.moveAllCarsOnce();
        game.moveAllCarsOnce();
        int maxMoveNum = WinnerFinder.getMaxMoveNum(cars);
        assertThat(maxMoveNum).isEqualTo(2);
    }

    @Test
    void 아무도_움직이지_않았을때_최대이동횟수() {
        Car car1 = new Car("pobi", new TestNumberGenerator(1));
        Car car2 = new Car("woni", new TestNumberGenerator(2));
        Car car3 = new Car("jun", new TestNumberGenerator(3));
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Game game = new Game(cars, 5);
        game.moveAllCarsOnce();
        game.moveAllCarsOnce();
        int maxMoveNum = WinnerFinder.getMaxMoveNum(cars);
        assertThat(maxMoveNum).isEqualTo(0);
    }

    @Test
    void 우승자_두명일때_이름_찾기() {
        Car car1 = new Car("pobi", new TestNumberGenerator(4));
        Car car2 = new Car("woni", new TestNumberGenerator(5));
        Car car3 = new Car("jun", new TestNumberGenerator(3));
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Game game = new Game(cars, 5);
        game.moveAllCarsOnce();
        game.moveAllCarsOnce();
        int maxMoveNum = 2;
        List<String> winners = WinnerFinder.getWinnerNames(cars, maxMoveNum); // pobi, woni
        assertThat(winners).containsOnly("pobi", "woni");
    }

    @Test
    void 우승자_한명일때_이름_찾기() {
        Car car1 = new Car("pobi", new TestNumberGenerator(4));
        Car car2 = new Car("woni", new TestNumberGenerator(1));
        Car car3 = new Car("jun", new TestNumberGenerator(3));
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Game game = new Game(cars, 5);
        game.moveAllCarsOnce();
        game.moveAllCarsOnce();
        int maxMoveNum = 2;
        List<String> winners = WinnerFinder.getWinnerNames(cars, maxMoveNum); // pobi
        assertThat(winners).containsOnly("pobi");
    }

}
