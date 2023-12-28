package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("입력값이 빈 문자열이면 예외를 반환한다.")
    void 입력값이_빈_문자열이면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값이 쉼표로 시작하면 예외를 반환한다.")
    void 입력값이_쉼표로_시작하면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,woni,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값이 쉼표로 끝나면 예외를 반환한다.")
    void 입력값이_쉼표로_끝나면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름에 중복이 존재하면 예외를 반환한다.")
    void 자동차_이름에_중복이_존재하면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,woni,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외를 반환한다.")
    void 자동차_이름이_빈_문자열이면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 반환한다.")
    void 자동차_이름이_5자를_초과하면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아니면 예외를 반환한다.")
    void 시도할_횟수가_숫자가_아니면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수가 0보다 작으면 예외를 반환한다.")
    void 시도할_횟수가_0보다_작으면_예외를_반환한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차의 이름과 위치를 출력한다.")
    void 자동차의_이름과_위치를_출력한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("최종 우승자를 출력한다.")
    void 최종_우승자를_출력한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 쉼표로 구분하여 출력한다.")
    void 우승자가_여러_명일_경우_쉼표로_구분하여_출력한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
