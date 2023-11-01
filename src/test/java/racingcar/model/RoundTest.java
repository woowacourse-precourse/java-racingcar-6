package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    void Round_객체_생성_성공() {
        try {
            Round r1 = new Round(0);
            Round r2 = new Round(1);
            Round r3 = new Round(Integer.MAX_VALUE);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    void 음수로_Round_객체_생성시_실패() {
        assertThrows(IllegalArgumentException.class, () -> {
            Round r = new Round(-1);
        });
    }

    @Test
    void decreaseByOne_실행후_결과_테스트() {
        Round r1 = new Round(0);
        Round r2 = new Round(1);

        assertFalse(r1.decreaseByOne());
        assertTrue(r2.decreaseByOne());
    }

    @Test
    void Round_equals_테스트() {
        Round r1 = new Round(0);
        Round r2 = new Round(0);
        Round r3 = new Round(0);
        Round r4 = new Round(0);

        // 반사성
        assertTrue(r1.equals(r1));

        // 대칭성
        if (r1.equals(r2)) {
            assertTrue(r2.equals(r1));
        }

        // 추이성
        if (r1.equals(r2) && r2.equals(r3)) {
            assertTrue(r1.equals(r3));
        }

        // 널
        assertNotEquals(null, r1);
    }
}