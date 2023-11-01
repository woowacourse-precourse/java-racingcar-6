package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 레이싱_게임_생성() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        int rounds = 5;
        RacingGame racingGame = new RacingGame(cars, rounds);

        assertNotNull(racingGame);
    }
    @Test
    void playRound() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        RacingGame racingGame = new RacingGame(cars, 5);
        for (Car car : cars) {
            car.move(5);
        }

        assertTrue(cars.stream().allMatch(car -> car.getPosition() >= 0));
    }
    @Test
    void 우승자_찾기() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(5);
        car2.move(3);
        List<Car> cars = Arrays.asList(car1, car2);
        RacingGame racingGame = new RacingGame(cars, 5);

        List<Car> winners = racingGame.findWinners();

        assertEquals(1, winners.size());
        assertTrue(winners.contains(car1));
    }
    @Test
    void 최대_위치_찾기(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(5);
        car2.move(3);
        List<Car> cars = Arrays.asList(car1, car2);
        RacingGame racingGame = new RacingGame(cars, 5);

        int maxPosition = racingGame.getMaxPosition();

        assertEquals(1, maxPosition);
    }


}