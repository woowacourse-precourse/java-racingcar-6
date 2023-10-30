package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
            INPUT_GAME_TURNS = "시도할 회수는 몇회인가요?",
            RUN_RESULT = "실행 결과";

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
    void 한명_단독우승() {
        String carNamesInput = "wtc";
        String gameTurnsInput = "3";
        Integer[] randoms = {STOP, MOVING_FORWARD};

        assertRandomNumberInRangeTest(
                () -> {
                    run(carNamesInput, gameTurnsInput);
                    assertThat(output()).contains(INPUT_CAR_NAMES, INPUT_GAME_TURNS, RUN_RESULT,
                            "wtc : -", "wtc : --", "최종 우승자 : wtc");
                },
                MOVING_FORWARD, randoms
        );
    }

    @Test
    void 두명_단독우승_역전없음() {
        String carNamesInput = "wtc, prcs";
        String gameTurnsInput = "3";
        Integer[] randoms = {STOP, MOVING_FORWARD};

        assertRandomNumberInRangeTest(
                () -> {
                    run(carNamesInput, gameTurnsInput);
                    assertThat(output()).contains(INPUT_CAR_NAMES, INPUT_GAME_TURNS, RUN_RESULT,
                            "wtc : -", "prcs : ",
                            "wtc : --", "prcs : -",
                            "wtc : ---", "prcs : --",
                            "최종 우승자 : wtc");
                },
                MOVING_FORWARD, randoms
        );
    }

    @Test
    void 두명_단독우승_역전() {

    }

    @Test
    void 두명_공동우승() {

    }

    @Test
    void 이름에_대한_예외_처리_길이초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_빈문자열() {

    }

    @Test
    void 시도회수_예외_처리_숫자가아닐때() {

    }

    @Test
    void 시도회수_예외_처리_음수() {

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
