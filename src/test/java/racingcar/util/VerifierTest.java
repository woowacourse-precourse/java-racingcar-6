package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VerifierTest {
    @Test
    void 입력_받은_차량_이름_예외_처리() {
        assertThatThrownBy(() -> Verifier.verifyCarNamesString(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyCarNamesString("ab ef,,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyCarNamesString("abef,,b,c,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차량_이름_중복_예외_처리() {
        assertThatThrownBy(() -> Verifier.verifyCarNameDuplication(new String[]{"a", "b", "a"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차량_이름_예외_처리() {
        assertThatThrownBy(() -> Verifier.verifyCarName(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyCarName("ab ef"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyCarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_예외_처리() {
        assertThatThrownBy(() -> Verifier.verifyTrialNumber(" "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyTrialNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyTrialNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyTrialNumber("1.1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Verifier.verifyTrialNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
