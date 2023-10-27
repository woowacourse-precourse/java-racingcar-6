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
                    run("bisi,basi", "1");
                    assertThat(output()).contains("bisi : -", "basi : ", "최종 우승자 : bisi");
                },
                MOVING_FORWARD, STOP // 두 자동차의 1회차 이동 난수 지정
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("bisi,basi", "1");
                    assertThat(output()).contains("bisi : ", "basi : ", "최종 우승자 : bisi, basi");
                },
                STOP, STOP // 두 자동차의 1회차 이동 난수 지정
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("bisi,basi,bibi", "3");
                    assertThat(output()).contains("bisi : ---", "basi : ---", "bibi : ---",
                            "최종 우승자 : bisi, basi, bibi");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,// 세 자동차의 1회차 이동 난수 지정
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,// 세 자동차의 2회차 이동 난수 지정
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD // 세 자동차의 3회차 이동 난수 지정
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        // 이름 length 5 초과
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bisi,bassssi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // 이름이 중복인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bisi,bisi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // 이름이 공백인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bisi,  ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",basi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // 구분자 이후 입력이 없는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bisi,basi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 회수에_대한_예외_처리() {
        // 1 이하의 숫자가 입력된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bisi,basi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        // 숫자가 아닌 값이 입력된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("bisi,basi", "hello!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
