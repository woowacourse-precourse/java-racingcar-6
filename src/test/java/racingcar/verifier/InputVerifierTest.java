package racingcar.verifier;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputVerifierTest {
    @DisplayName("5자를 넘어가는 이름 입력에 대한 테스트")
    @Test
    void checkLonger() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.verifyName("가나다라마,가나다라마바"));
    }

    @DisplayName("이름이 없는 자동차에 대한 테스트")
    @Test
    void checkNull() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.verifyName(",,,차"));
    }

    @DisplayName("아무런 입력도 주어지지 않았을 때 테스트")
    @Test
    void checkTotallyNull() {
        assertThrows(IllegalArgumentException.class, () -> InputVerifier.verifyName(""));
    }
}
