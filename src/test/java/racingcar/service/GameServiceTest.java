package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest extends NsTest {

    private static final GameService gameService = new GameService();
    private static final Output output = new Output();
    private static final int attemptCount = 1;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        cars.add(car1);
        cars.add(car2);
    }

    @AfterEach
    public void afterEach() {
        cars.clear();
    }

    @Override
    protected void runMain() {
        gameService.proceedRacing(attemptCount, cars);
        output.printGameWinner(gameService.getWinner(cars));
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("a : -", "b :");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_하나_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("최종 우승자 : a");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_여러명_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run();
                    assertThat(output()).contains("최종 우승자 : a, b");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}