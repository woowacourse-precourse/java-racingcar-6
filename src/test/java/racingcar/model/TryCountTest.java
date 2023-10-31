package racingcar.model;

import model.TryCount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName    : racingcar.model
 * fileName       : TryCountTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    public void 정상_시도횟수(String string) {
        TryCount tryCount = new TryCount(string);
        assertThat(tryCount).isNotNull();
    }
    @ParameterizedTest
    @ValueSource(strings = {"시도", "횟수"})
    public void 생성_예외_문자입력(String tryCountString) {

        assertThatThrownBy(() -> new TryCount(tryCountString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2"})
    public void 생성_예외_음수입력(String tryCountString) {

        assertThatThrownBy(() -> new TryCount(tryCountString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-2"})
    public void 생성_예외_문자와_음수입력(String tryCountString) {

        assertThatThrownBy(() -> new TryCount(tryCountString))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
