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

    // moomint8 직접 구현한 테스트 코드 start
    @Test
    void 이름_쉼표로_나누기() {
        run("benz,bmw,dodge", "1");
        assertThat(output()).contains("benz : ", "bmw : ", "dodge : ");
    }

    @Test
    void 다섯_자리_초과_이름에_대한_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("benz,bmw,hyundai", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 한_자리_미만_이름에_대한_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("benz,bmw,,audi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("benz,bmw,benz", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 선수가_둘_미만인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("benz", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시행횟수_숫자가_아닌_입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("benz,bmw", "1a5b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시행횟수_자연수가_아닌_입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("benz,bmw", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("benz,bmw", "1");
                    assertThat(output()).contains("benz : -", "bmw :");
                },
                4, 3
        );
    }

    @Test
    void 실행결과_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("benz,bmw", "3");
                    assertThat(output()).contains("benz : -", "bmw : ",
                            "benz : -", "bmw : -",
                            "benz : --", "bmw : -");
                },
                4, 3, 1, 9, 6, 2
        );
    }

    @Test
    void 공동_우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("benz,bmw,audi", "1");
                    assertThat(output()).contains("benz : -", "bmw : ", "audi : ",
                            "최종 우승자 : benz, bmw");
                },
                8, 4, 1
        );
    }
    // moomint8 직접 구현한 테스트 코드 end

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
