package racingcar.race;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundCountTest {
    @Test
    void 이동횟수_입력_문자_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new RoundCount("a"));
    }

    @Test
    void 이동횟수_입력_숫자_범위초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new RoundCount(String.valueOf(Integer.MAX_VALUE + 1)));
    }

    @Test
    void 이동횟수_입력_숫자_범위미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new RoundCount("-1"));
    }

    @Test
    void 이동횟수_범위_확인(){
        RoundCount roundCount = new RoundCount("1");
        assertTrue(roundCount.isRemained());

        roundCount.decreaseCount();
        assertFalse(roundCount.isRemained());
    }
    @Test
    void 이동횟수_감소() {
        RoundCount roundCount = new RoundCount("1");
        roundCount.decreaseCount();
        assertEquals(0, roundCount.getRoundCount());

    }

    @Test
    void 이동횟수_언더플로우_테스트() {
        RoundCount roundCount = new RoundCount("1");

        roundCount.decreaseCount();
        roundCount.decreaseCount();
        assertEquals(0, roundCount.getRoundCount());
    }

    @Test
    void 이동횟수_입력_숫자_정상() {
        assertDoesNotThrow(() -> new RoundCount("1"));
    }

    @Test
    void 이동횟수_getter() {
        RoundCount roundCount = new RoundCount("1");
        assertEquals(1, roundCount.getRoundCount());
    }
}