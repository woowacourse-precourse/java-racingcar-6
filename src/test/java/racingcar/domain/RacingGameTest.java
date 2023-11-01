package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void 초기세팅() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        racingGame = new RacingGame(cars, 3);
    }

    @Test
    void 자동차리스트_생성확인() {
        List<Car> cars = racingGame.getCarList();
        assertEquals(2, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
    }

    @Test
    void 게임횟수_입력확인() {
        assertEquals(3, racingGame.getRaceCount());
    }
}
