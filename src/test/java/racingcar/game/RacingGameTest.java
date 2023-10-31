package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("RacingGame 객체 생성 시, 차 이름이 알맞게 생성된다.")
    void racingGameNameTest() {
        List<Car> carList = racingGame.getCarList();

        assertAll(
                () -> assertEquals(carList.get(0).getName(), "poby"),
                () -> assertEquals(carList.get(1).getName(), "woni"),
                () -> assertEquals(carList.get(2).getName(), "jun")
        );
    }

    @Test
    @DisplayName("RacingGame 객체 생성 시, 거리가 모두 0으로 초기화된다.")
    void racingGameDistanceTest() {
        List<Car> carList = racingGame.getCarList();

        assertAll(
                carList.stream()
                        .map(car -> () -> assertEquals(0, car.getDistance()))
        );
    }

    @Test
    @DisplayName("4보다 큰 수에 대하여 움직이는 것을 검증한다.")
    void racingGameMoveTest() {
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
    @DisplayName("4보다 작은 수에 대하여 움직이지 않는 것을 검증한다.")
    void racingGameCantMoveTest() {
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
    @DisplayName("움직이는 것을 검증한다.")
    public void moveTest() {
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
    @DisplayName("거리가 가장 긴 우승자를 최종 우승자로 반환한다.")
    void getWinnersMostDistanceTest() {
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
    @DisplayName("최종우승자가 여러 명일 경우, 모두 반환한다.")
    void getWinnersTest() {
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