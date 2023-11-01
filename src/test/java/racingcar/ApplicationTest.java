package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_입력된_공백_제거_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi  ,  woni, uk  ", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "uk : -", "최종 우승자 : uk");
                },
                STOP, STOP, MOVING_FORWARD

        );
    }

    @Test
    void 공동_우승자에_대한_출력_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,uk", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "uk : -", "최종 우승자 : pobi, uk");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD

        );
    }

    @Test
    void 게임횟수_입력이_0인_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "er1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임횟수_입력이_숫자가_아닌_경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_없는경우_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,uk", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_공백인경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,  ,uk", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름이_5글자가_넘는_경우예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
