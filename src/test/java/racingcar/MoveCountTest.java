package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoveCountTest {
    @Test
    void 이동횟수_입력_문자_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new MoveCount("a"));
    }

    @Test
    void 이동횟수_입력_숫자_범위초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new MoveCount(String.valueOf(Integer.MAX_VALUE + 1)));
    }

    @Test
    void 이동횟수_입력_숫자_범위미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new MoveCount("-1"));
    }

    @Test
    void 이동횟수_입력_숫자_정상() {
        assertDoesNotThrow(() -> new MoveCount("1"));
    }

    @Test
    void 이동횟수_getter() {
        MoveCount moveCount = new MoveCount("1");
        assertEquals(1, moveCount.getMoveCount());
    }
}