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
    void 비어있는_이름_입력시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.carsName("", new String[]{""}))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_중복_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_최대_길이_제한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef,ghi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 레이스_횟수_입력_예외_처리() {
        String carName = "abc,def"; // there is no exception
        String raceTime = "5a"; // expect to occur exception
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, raceTime))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 자동차_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("abc : -", "abc : --", "abc : ---", "def : -",
                            "def : --", "def : ---");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 자동차_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("abc : ", "def : ");
                },
                STOP
        );
    }

    @Test
    void 다수_승리자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("최종 우승자 : abc, def");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 단일_승리자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("최종 우승자 : abc");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
