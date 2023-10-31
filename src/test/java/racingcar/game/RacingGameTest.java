package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String[] cars = {"poby", "woni", "jun"};
        racingGame = new RacingGame(cars);
    }

    @Test
    void name_객체_생성시_차_이름_생성() {
        List<Car> carList = racingGame.getCarList();

        assertAll(
                () -> assertEquals(carList.get(0).getName(), "poby"),
                () -> assertEquals(carList.get(1).getName(), "woni"),
                () -> assertEquals(carList.get(2).getName(), "jun")
        );
    }

    @Test
    void distance_객체_생성시_거리_모두_0으로_초기화() {
        List<Car> carList = racingGame.getCarList();

        assertAll(
                carList.stream()
                        .map(car -> () -> assertEquals(0, car.getDistance()))
        );
    }

    @Test
    void canMove_4보다_큰수에_대하여_움직임_가능() {
        try {
            int number = 6;
            Method canMoveMethod = RacingGame.class.getDeclaredMethod("canMove", int.class);
            canMoveMethod.setAccessible(true);
            boolean result = (boolean) canMoveMethod.invoke(racingGame, number);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void canMove_4보다_작은수에_대하여_움직임_불가능() {
        try {
            int number = 2;
            Method canMoveMethod = RacingGame.class.getDeclaredMethod("canMove", int.class);
            canMoveMethod.setAccessible(true);
            boolean result = (boolean) canMoveMethod.invoke(racingGame, number);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void move_한칸_움직임_검증() {
        List<Car> carList = racingGame.getCarList();
        for (Car car : carList) {
            car.move();
            car.move();
        }

        assertAll(
                carList.stream()
                        .map(car -> () -> assertEquals(2, car.getDistance()))
        );
    }

    @Test
    void getWinners_거리가_가장_긴_최종우승자_반환() {
        List<Car> carList = racingGame.getCarList();
        for (int i = 0; i < 3; ++i) {
            carList.get(0).move();
        }

        List<Car> winners = racingGame.getWinners();

        assertEquals(winners.size(), 1);
        assertEquals(winners.get(0).getName(), "poby");
        assertEquals(winners.get(0).getDistance(), 3);
    }

    @Test
    void getWinners_최종우승자_모두_반환() {
        List<Car> carList = racingGame.getCarList();
        for (Car car : carList) {
            car.move();
            car.move();
        }

        List<Car> winners = racingGame.getWinners();

        assertEquals(winners.size(), 3);
        assertEquals(winners.get(0).getName(), "poby");
        assertEquals(winners.get(1).getName(), "woni");
        assertEquals(winners.get(2).getName(), "jun");
        assertAll(
                carList.stream()
                        .map(car -> () -> assertEquals(2, car.getDistance()))
        );
    }
}