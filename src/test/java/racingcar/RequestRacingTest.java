package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RequestRacingTest {

    private static RequestRacing requestRacing;

    @BeforeAll
    static void 테스트_시작전() {
        requestRacing = new RequestRacing();
    }

    @Test
    void 자동차_이름_길이_5자_제한() {
        assertThatThrownBy(() -> requestRacing.validationCarNames(new String[]{"pobi", "woooooooooni", "jun"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_공백_이름_제한() {
        assertThatThrownBy(() -> requestRacing.validationCarNames(new String[]{"pobi", "    ", "jun"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_유무_제한() {
        assertThatThrownBy(() -> requestRacing.validationCarNames(new String[]{"pobi", "", "jun"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
