package racingcar.verifier;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.system.ExceptionMessage;

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

    @Test
    void 숫자가아닌입력이_주어진경우() {
        Assertions.assertThatThrownBy(()->attemptsNumVerifier.check("35k"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMERIC);
    }

    @Test
    void 유효한범위의_숫자가_아닌_입력이_아닌경우() {
        Assertions.assertThatThrownBy(()->attemptsNumVerifier.check("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NUM_OF_ATTEMPTS);
    }
}