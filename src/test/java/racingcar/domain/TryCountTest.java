package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TryCount 테스트")
public class TryCountTest {

    @Test
    @DisplayName("TryCount 객체 생성 성공 테스트")
    void createTryCountSuccess() {
        assertDoesNotThrow(() -> new TryCount(5));
    }

    @Test
    @DisplayName("TryCount 객체 생성 실패 (유효하지 않은 값) 테스트")
    void createTryCountWithInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new TryCount(-1));
    }

    @Test
    @DisplayName("decreaseCount 메서드 테스트")
    void decreaseCount() {
        TryCount tryCount = new TryCount(3);

        tryCount.decreaseCount();
        assertEquals(2, tryCount.getTryCount());
    }


    @Test
    @DisplayName("hasRepeat 메서드 테스트")
    void hasRepeat() {
        TryCount tryCountWithPositiveValue = new TryCount(3);
        assertTrue(tryCountWithPositiveValue.hasRepeat());
    }

}
