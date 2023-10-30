package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.car.UserInputCarName;
import racingcar.game.UserInputGameRound;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5초과_입력시_예외_처리() {
        String inputCarName = "123456";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputCarName.processInput(inputCarName);
        });
    }

    @Test
    void 중복된_자동차_이름_입력시_예외_처리() {
        String inputCarName = "car1,car2,car1";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputCarName.processInput(inputCarName);
        });
    }

    @Test
    void 경주할_자동차가_0개_예외_처리() {
        String inputCarName = " ";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputCarName.processInput(inputCarName);
        });
    }

    @Test
    void 문자열_시도_횟수_입력시_예외_처리() {
        String gameRound = "abc";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }

    @Test
    void 음수_시도_횟수_입력시_예외_처리() {
        String gameRound = "-2";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }

    @Test
    void 공백_시도_횟수_입력시_예외_처리() {
        String gameRound = " ";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }

    @Test
    void 시도_횟수_0번_입력시_예외_처리() {
        String gameRound = "0";
        assertThrows(IllegalArgumentException.class, () -> {
            UserInputGameRound.processInput(gameRound);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
