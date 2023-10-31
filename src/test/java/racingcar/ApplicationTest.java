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

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                0, 4, 5, 1, 6, 2, 3, 7, 8, 9
        );
    }

    @Test
    void 단독_우승자일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP
        );
    }

    @Test
    void 매_횟수_마다_실행_결과_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "5");
                    assertThat(output()).contains("pobi : -", "woni : ", "pobi : --", "woni : ", "pobi : ---",
                            "woni : ", "pobi : ----", "woni : ", "pobi : -----", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP
        );
    }

    @Test
    void 우승자가_여러명일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,java", "5");
                    assertThat(output()).contains(
                            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                            "시도할 회수는 몇회인가요?",
                            "실행 결과",
                            "pobi : -",
                            "woni : -",
                            "java : -",
                            "pobi : --",
                            "woni : --",
                            "java : --",
                            "pobi : ---",
                            "woni : ---",
                            "java : ---",
                            "pobi : ----",
                            "woni : ----",
                            "java : ----",
                            "pobi : -----",
                            "woni : -----",
                            "java : -----",
                            "최종 우승자 : pobi, woni, java"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );

    }

    @Test
    void 이름_길이에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_문자가_아닐_때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("poㅇbi,javaj", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_중복일_때_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_할_횟수가_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobia", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
