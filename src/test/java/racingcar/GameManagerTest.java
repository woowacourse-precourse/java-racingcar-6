package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class GameManagerTest {
    private static final int MOVING_NUMBER = 4;
    private static final int STOP_NUMBER = 2;

    private GameManager gameManager;
    private Car car;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
        car = new Car("test");
    }

    @Test
    void 전진(){
        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCar(car);
                    assertThat(car.getLocation()).isEqualTo(1);
                },
                MOVING_NUMBER
        );
    }

    @Test
    void 정지(){
        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCar(car);
                    assertThat(car.getLocation()).isEqualTo(0);
                },
                STOP_NUMBER
        );
    }
}
