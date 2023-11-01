package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racingGame.Car;

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
    @DisplayName("자동차의 이름은 5자 이하만 가능")
    void t001() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobicar,javajigicar"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("이동하는 횟수는 1 이상 이어야 함")
    void t002() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("우승자가 둘 이상이라면, 쉼표로 모두 출력되어야 함")
    void t003() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차의 이름은 공백이 될 수 없습니다")
    void t004() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobicar,    "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("이동하는 횟수는 숫자만 가능해야함")
    void t005() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
