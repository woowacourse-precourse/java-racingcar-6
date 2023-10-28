package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class GameManagerTest {
    private static final int MOVING_NUMBER = 4;
    private static final int STOP_NUMBER = 2;
    private static final String CAR_NAME = "test";

    private GameManager gameManager;
    private Car car;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
        car = new Car(CAR_NAME);
    }

    @Test
    void 전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCar(car);
                    assertThat(car.getLocation()).isEqualTo(1);
                },
                MOVING_NUMBER
        );
    }

    @Test
    void 정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCar(car);
                    assertThat(car.getLocation()).isEqualTo(0);
                },
                STOP_NUMBER
        );
    }


    @Test
    void 자동차_전진_결과_생성() {
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCar(car);
                    gameManager.moveCar(car);
                    assertThat(gameManager.makeResult(cars)).isEqualTo(CAR_NAME + " : --\n");
                },
                MOVING_NUMBER, MOVING_NUMBER
        );
    }

    @Test
    void 자동차_정지_결과_생성() {
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCar(car);
                    assertThat(gameManager.makeResult(cars)).isEqualTo(CAR_NAME + " : \n");
                },
                STOP_NUMBER
        );
    }
}
