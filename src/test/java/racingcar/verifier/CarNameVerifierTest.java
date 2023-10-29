package racingcar.verifier;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameVerifierTest {

    private final Verifier carNameVerifier = new CarNameVerifier();

    @Test
    void 정상입력이주어진경우() {
       Assertions.assertThatCode(()-> carNameVerifier.check("pobi,woni,jun"))
               .doesNotThrowAnyException();
    }
}