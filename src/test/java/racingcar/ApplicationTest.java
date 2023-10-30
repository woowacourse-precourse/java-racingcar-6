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
    void run_전진_정지_게임_종료() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,songe", "2", "2");
                assertThat(output()).contains("pobi : --", "songe : -", "최종 우승자 : pobi", "게임 종료");
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void name_이름에_공백이_있을_경우_공백도_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po bi,songe", "2", "2");
                    assertThat(output()).contains("po bi : --", "songe : -", "최종 우승자 : po bi");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void name_최종_우승자_두명_이상일_경우_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,songe", "2", "2");
                    assertThat(output()).contains("pobi : --", "songe : --", "최종 우승자 : pobi, songe");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void name_구분자가_포함되지_않은_경우_값을_그대로_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1", "2");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void reStart_게임_종료후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,songe", "1", "1", "yeln,poly", "1", "2");
                    assertThat(output()).contains("pobi : -", "songe : ", "최종 우승자 : pobi", "게임 종료"
                    ,"yeln : -", "poly : ", "최종 우승자 : yeln", "게임 종료");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void name_자동차_이름이_5_초과_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,songyii", "1", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void name_자동차_이름이_빈_문자열_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,songe", "1", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void name_횟수가_1_이상의_숫자_외_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,songye", "k", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
