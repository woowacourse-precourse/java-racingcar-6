package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class CountTest {

    @Test
    void 시도_횟수가_숫자가_아닐경우_예외를_던진다() {
        assertThrows(IllegalArgumentException.class, () -> new Count("a"));
    }

    @Test
    void 시도_횟수가_음수일_경우_예외를_던진다() {
        assertThrows(IllegalArgumentException.class, () -> new Count("-1"));
    }

    @Test
    void count가_0일_경우_턴_종료() {
        Count count = new Count("1");
        count.countDown();

        assertTrue(count.isEnd());
    }

    @Test
    void count가_양수일_경우_턴_지속() {
        Count count = new Count("1");

        assertFalse(count.isEnd());
    }

    @Test
    void 카운트다운_테스트() {
        Count count = new Count("3");

        count.countDown();
        count.countDown();
        count.countDown();

        assertTrue(count.isEnd());
    }
}
