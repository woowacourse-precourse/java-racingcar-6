package racinggame;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.GameDetail;
import racingcar.exception.MoveCountExceptionMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 이동 횟수에 대한 검증 테스트
 */
public class MoveCountValidationTest extends NsTest {

    public static final String CAR_NAMES = "a" + GameDetail.CAR_SEPARATOR + "b" + GameDetail.CAR_SEPARATOR + "c";

    @Test
    @DisplayName("이동 횟수 숫자 외 입력시 예외 발생")
    void validate_move_count_not_num() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CAR_NAMES, "가"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoveCountExceptionMessage.NOT_POSITIVE_NUMBER)
        );
    }

    @Test
    @DisplayName("이동 횟수 0 입력시 예외 발생")
    void validate_move_count_zero() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CAR_NAMES, "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoveCountExceptionMessage.NOT_POSITIVE_NUMBER)
        );
    }

    @Test
    @DisplayName("이동 횟수 소수 입력시 예외 발생")
    void validate_move_count_decimal() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CAR_NAMES, "1.1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoveCountExceptionMessage.NOT_POSITIVE_NUMBER)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
