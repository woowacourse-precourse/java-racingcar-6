package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void printWell() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void nameNoInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameLastComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameOverFive() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,donghaoh", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameDuplicate() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nameManyComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,,,dong,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void roundNumberNoInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void roundNumberEnglish() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong", "agew"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void roundNumberKorean() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong", "ㅎ이팅"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void roundNumberDecimal() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong", "12.468"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void roundNumberMinus() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong", "-2346"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void roundNumberTooBig() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,dong", "12823748270234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
