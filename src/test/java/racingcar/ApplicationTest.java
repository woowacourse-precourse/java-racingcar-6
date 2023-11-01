package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("정상적으로 값이 입력되었을 때 통과한다. (우승자 한명)")
    void 단일_우승_정상_입력() {
        assertRandomNumberInRangeTest(
            () -> {
                run("seona,moon,uteco", "2");
                assertThat(output()).contains("seona : -", "moon : ", "uteco : --",
                    "최종 우승자 : uteco");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("정상적으로 값이 입력되었을 때 통과한다. (우승자 여러명)")
    void 중복_우승_정상_입력() {
        assertRandomNumberInRangeTest(
            () -> {
                run("seona,moon,uteco", "2");
                assertThat(output()).contains("seona : --", "moon : -", "uteco : --",
                    "최종 우승자 : seona, uteco");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("중복된 이름이 있으면 예외가 발생한다")
    void 중복_이름_예외_처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("seona,seona", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("공백의 입력에는 예외가 발생한다")
    void 공백_입력_예외_처리1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("공백의 입력에는 예외가 발생한다")
    void 공백_입력_예외_처리2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("seona,moon", " "))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName(",,사이에 공백의 값이 입력되면 예외가 발생한다")
    void 이름_예외_처리1() { //
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,b,,c", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName(",,사이에 공백의 값이 입력되면 예외가 발생한다")
    void 이름_예외_처리2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,b,,,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName(",,사이에 공백의 값이 입력되면 예외가 발생한다")
    void 이름_예외_처리3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",,,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름에 공백이 포함되면 제거하고 정상적으로 실행된다")
    void 이름_예외_처리4() {
        assertRandomNumberInRangeTest(
            () -> {
                run("seo na,moon ", "1");
                assertThat(output()).contains("seona : -", "moon : ", "최종 우승자 : seona");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("시행횟수가 음수이면 에러가 발생한다")
    void 시행횟수_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("seona,moon", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시행횟수가 유리수이면 에러가 발생한다")
    void 시행횟수_유리수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("seona,moon", "1.34"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시행횟수에 문자가 포함되면 에러가 발생한다")
    void 시행횟수_문자1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("seona,moon", "a"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시행횟수에 문자가 포함되면 에러가 발생한다")
    void 시행횟수_문자2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("seona,moon", "a32"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
