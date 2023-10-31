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
    void 시도_횟수_정상_검사() {
        assertSimpleTest(() -> {
            run("자동차1,자동차2", "3");
            assertThat(output()).containsPattern("(자동차1 : -{0,3}\\n자동차2 : -{0,3}\\n\\n){3}");
        });
    }

    @Test
    void 자동차_이름_길이_제한_검사() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("자동차123,자동차2", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_미입력_검사() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_시도_횟수_검사() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("자동차1,자동차2", "세번"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 다수_우승자_검사() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("자동차1,자동차2", "5");
                    assertThat(output()).containsPattern("최종 우승자 : (자동차1, 자동차2|자동차2, 자동차1)");
                },
                4, 9
        );
    }

    @Test
    void 단일_우승자_검사() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("자동차1,자동차2", "5");
                    assertThat(output()).containsPattern("최종 우승자 : 자동차1|최종 우승자 : 자동차2");
                },
                4, 9
        );
    }

    @Test
    void 모든_자동차_정지_검사() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("자동차1,자동차2", "5");
                    assertThat(output()).doesNotContain("자동차1 : -", "자동차2 : -");
                },
                0, 3
        );
    }

    @Test
    void 랜덤_이동_검사() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("자동차1", "5");
                    assertThat(output()).containsPattern("자동차1 : -{0,5}");
                },
                0, 9
        );
    }

    @Test
    void 음수_시도_횟수_검사() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("자동차1,자동차2", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_포함_자동차_이름_검사() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("자동 차1,자동차2", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_제로_검사() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("자동차1,자동차2", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
