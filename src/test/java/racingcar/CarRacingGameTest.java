package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.Constant.SPLIT_REGEX;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class CarRacingGameTest {
    private static final String CAR_NAME = "가";
    private static final String SET = "1";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static Car car;
    private static Game game;

    @BeforeAll
    static void setup() {

        car = new Car(List.of(CAR_NAME.split(SPLIT_REGEX)));

        game = new Game(car, SET);
    }

    @Test
    @DisplayName("자동차 경주 게임 진행 - 0이상 3이하의 경우 자동차 전진")
    void 멈춤_조건에서_자동차_멈춤_여부_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    int beforeMove = car.getMove(CAR_NAME);

                    game.playSet();

                    int afterMove = car.getMove(CAR_NAME);

                    assertThat(afterMove).isEqualTo(beforeMove);
                },
                STOP
        );
    }

    @Test
    @DisplayName("자동차 경주 게임 진행 - 4이상 9이하의 경우 자동차 전진")
    void 전진_조건에서_자동차_전진_여부_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    int beforeMove = car.getMove(CAR_NAME);

                    game.playSet();

                    int afterMove = car.getMove(CAR_NAME);

                    assertThat(afterMove).isEqualTo(beforeMove + 1);
                },
                MOVING_FORWARD
        );
    }
}
