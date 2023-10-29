package racingcar.verifier;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttemptsNumVerifierTest {
    
    private Verifier attemptsNumVerifier;
    
    
    @BeforeEach
    void setUp (){
        attemptsNumVerifier = new AttemptsNumVerifier();
    }

    @Test
    void 정상입력이_주어진경우() {
        Assertions.assertThatCode(()->attemptsNumVerifier.check("56"))
                .doesNotThrowAnyException();
    }
}