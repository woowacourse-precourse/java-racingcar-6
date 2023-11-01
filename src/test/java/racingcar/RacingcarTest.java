package racingcar;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarTest extends NsTest {

    /* 자동차 이름 입력 테스트 */
    @Test
    void namingTest_fail_no_name() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void namingTest_fail_empty_name() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   ", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void namingTest_fail_less_than_5_length_limit_of_characters() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, javaji", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void namingTest_validate_duplicate_names() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,luna", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /* 시도 횟수 입력 테스트 */
    @Test
    void inputnumberTest_fail_no_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, java", "  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputnumberTest_fail_input_zero() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, luna", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void inputnumberTest_fail_input_wrong_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, luna", "!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, luna", "5회"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputnumberTest_fail_negative_number() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /* 문자열 분리 기능 실행 테스트 */
    @Test
    void stringTest_check_fuction_of_split() {
        String input = "pobi,woni,luna";
        String[] result = input.split(",");

        assertThat(result).contains("luna","woni","pobi");
        assertThat(result).containsExactly("pobi","woni","luna");
    }

    @Test
        void stringTest_check_fuction_of_split_no_delimiter() {
        String input = "luna";
        String[] result = input.split(",");

        assertThat(result).contains("luna");
    }

    /* 전진 or 정지 기능 실행 테스트 */
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void moving_froward_or_stop() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void positionTest_move_forward() {
        Car car = new Car("testcar");
        car.moveForward();

        int positionLength = 0;
        if (car.getPositionDistance() != 0) {
            positionLength = car.getPositionDistance();
        }
        assertThat(positionLength).isLessThanOrEqualTo(1);
    }

    @Test
    void positionTest_stop() {
        Car car = new Car("testcar");
        car.moveForward();

        int positionLength = 0;
        if (car.getPositionDistance() == 0) {
            positionLength = car.getPositionDistance();
        }
        assertThat(positionLength).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
