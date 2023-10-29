package racingcar.verifier;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.system.ExceptionMessage;

class CarNameVerifierTest {

    private final Verifier carNameVerifier = new CarNameVerifier();

    @Test
    void 정상입력이주어진경우() {
       Assertions.assertThatCode(()-> carNameVerifier.check("pobi,woni,jun"))
               .doesNotThrowAnyException();
    }

    @Test
    void 자동차이름5자이하가아닌경우() {
        Assertions.assertThatThrownBy(()-> carNameVerifier.check("pobi,woni,123456,ifj"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME);
    }

}