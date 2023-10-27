package racingcar.verifier;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputVerifierTest {
    @DisplayName("5자를 넘어가는 이름 입력에 대한 테스트")
    @Test
    void checkLonger() {
        assertThrows(IllegalArgumentException.class, () -> InpurVerifier.verifyName("가나다라마바사,김수환무거북이와두루미"));
    }
}
