package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 차_생성() {
        CarController carController = new CarController();
        List<Car> cars = carController.makeCar("talal,sun");
        assertSimpleTest(() -> {
                    assertThat(cars.get(0).getName()).isEqualTo("talal");
                    assertThat(cars.get(1).getName()).isEqualTo("sun");
                }
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_생성() {
        GameController gameController = new GameController();
        Game game = gameController.makeRound("2");
        assertThat(game.getMaxRoundNumber()).isEqualTo(2);
    }

    @Test
    void 라운드_숫자에_대한_예외_처리() {
        GameController gameController = new GameController();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> gameController.makeRound("가나다"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
