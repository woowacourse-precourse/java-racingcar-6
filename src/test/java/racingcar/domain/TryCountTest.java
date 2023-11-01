package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TryCountTest {

    private static final int VALID_COUNT = 3;

    @Test
    void 정상_시도_횟수() {
        //when
        TryCount tryCount = new TryCount(VALID_COUNT);

        //then
        assertThat(tryCount.value()).isEqualTo(VALID_COUNT);
    }

    @Test
    void 음수_예외() {
        //given
        int negativeCount = -1;

        //when % then
        assertThatThrownBy(() -> new TryCount(negativeCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력 가능합니다.");
    }

    @Test
    void 영_예외() {
        //given
        int zeroCount = 0;

        //when % then
        assertThatThrownBy(() -> new TryCount(zeroCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력 가능합니다.");
    }

    @Test
    void 너무_큰_횟수_예외() {
        //given
        int bigCount = Integer.MAX_VALUE;

        //when % then
        assertThatThrownBy(() -> new TryCount(bigCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 입력입니다.");
    }

}
