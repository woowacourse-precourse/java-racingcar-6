package racingcar.verifier;


import org.junit.jupiter.api.Test;
import racingcar.system.ExceptionMessage;

import static org.assertj.core.api.Assertions.*;

class CarNameVerifierTest {

    private final Verifier carNameVerifier = new CarNameVerifier();

    @Test
    void 정상입력이_주어진경우() {
        assertThatCode(() -> carNameVerifier.check("pobi,woni,jun"))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차이름이_5자이하가_아닌경우() {
        assertThatThrownBy(() -> carNameVerifier.check("pobi,woni,123456,ifj"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME);
    }

}