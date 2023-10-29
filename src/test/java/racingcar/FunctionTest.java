package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionTest extends NsTest {
    private static final int MOVING_FORWARD = 4;

    @Test
    void 쉼표가_없는_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표만_있는_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표가_하나만_있는_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표로_시작_하는_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 쉼표로_끝나는_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차가_하나인_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차가_100개_이상인_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차가_공백인_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차가_공백을_포함한_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 ,2", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_없는_자동차를_포함한_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_중복된_자동차를_포함한_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,1", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수가_아닌_회차를_입력한_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 한_회차_미만을_입력한_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 백_회차_초과를_입력한_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2", "30000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
