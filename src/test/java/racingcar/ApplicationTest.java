package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.ExceptionMessage;

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
                        .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage())
        );
    }

    @Test
    @DisplayName("이름 중복 검사")
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,java,C++", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_DUPLICATE.getMessage())
        );
    }

    @Test
    @DisplayName("아무도 전진하지 않음")
    void 우승자가_여러명일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3", "1");
                    Assertions.assertThat(output()).contains("car1 : ", "car2 : ","car3 : ", "최종 우승자 : car1, car2, car3");
                },
                STOP,STOP,STOP
        );
    }

    @Test
    @DisplayName("모두 끝까지 전진")
    void 우승자가_여러명일_경우2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car1,car2,car3", "3");
                    Assertions.assertThat(output()).contains("car1 : ", "car2 : ","car3 : ", "최종 우승자 : car1, car2, car3");
                },
                5,5,5,5,5,5,5,5,5
        );
    }

    @Test
    void 횟수_입력이_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,car2,car3", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
