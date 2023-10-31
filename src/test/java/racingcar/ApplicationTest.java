package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static resource.TestData.BLANK;
import static resource.TestData.CAR_NAME_1;
import static resource.TestData.CAR_NAME_2;
import static resource.TestData.COMMA;
import static resource.TestData.COMMA_WITH_SPACE;
import static resource.TestData.LONG_CAR_NAME;
import static resource.TestData.ONE;
import static resource.TestData.ZERO;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(CAR_NAME_1 + COMMA + CAR_NAME_2, String.valueOf(ONE));
                    assertThat(output()).contains(CAR_NAME_1 + " : -", CAR_NAME_2 + " : ", "최종 우승자 : " + CAR_NAME_1);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 긴_이름에_대한_예외_처리() {
        String carName = CAR_NAME_1 + COMMA + LONG_CAR_NAME;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, String.valueOf(ONE)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_포함_이름에_대한_예외_처리() {
        String carName = CAR_NAME_1 + COMMA_WITH_SPACE;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, String.valueOf(ONE)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_이름에_대한_예외_처리() {
        String carName = CAR_NAME_1 + COMMA;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, String.valueOf(ONE)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_입력에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(BLANK, String.valueOf(ONE)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_0에_대한_예외_처리() {
        String carName = CAR_NAME_1 + COMMA + CAR_NAME_2;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, String.valueOf(ZERO)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_시도_횟수에_대한_예외_처리() {
        String carName = CAR_NAME_1 + COMMA + CAR_NAME_2;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_뷰() {
        run(CAR_NAME_1 + COMMA + CAR_NAME_2, String.valueOf(ONE));
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 출력_뷰() {
        run(CAR_NAME_1 + COMMA + CAR_NAME_2, String.valueOf(ONE));
        assertThat(output()).contains("시도할 회수는 몇회인가요?");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
