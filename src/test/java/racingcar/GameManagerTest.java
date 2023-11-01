package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class GameManagerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String carName = "pobi";
    private static final List<String> carNames = Arrays.asList("pobi", "woni", "jun");

    private GameManager gameManager;
    private Car car;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @Test
    void 자동차_전진_결과_생성() {
        gameManager.addCar(carName);

        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCars();
                    gameManager.moveCars();
                    assertThat(gameManager.makeResult()).isEqualTo("pobi : --\n");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_정지_결과_생성() {
        gameManager.addCar(carName);

        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCars();
                    assertThat(gameManager.makeResult()).isEqualTo("pobi : \n");
                },
                STOP
        );
    }

    @Test
    void 단독_우승자_출력() {
        carNames.forEach(carName -> gameManager.addCar(carName));

        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCars();
                    assertThat(gameManager.makeWinnerResult()).isEqualTo("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 공동_우승자_출력() {
        carNames.forEach(carName -> gameManager.addCar(carName));

        assertRandomNumberInRangeTest(
                () -> {
                    gameManager.moveCars();
                    assertThat(gameManager.makeWinnerResult()).isEqualTo("최종 우승자 : pobi,jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }
}
