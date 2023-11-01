package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final Game game = new Game();

    Car car = new Car("apple", 9);
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void before() {
        cars.add(car);

    }

    @Test
    void judgeMoving() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(car.getMovingCnt()).isEqualTo(10);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {
        game.judgeMoving(cars);
    }
}