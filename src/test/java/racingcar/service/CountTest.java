package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CountTest {
    @Test
    void 증가_횟수가_같다면_같다() {
        Count first = Count.zero();
        Count second = Count.zero();
        first.plusOne();
        second.plusOne();
        assertEquals(first, second);
    }

    @Test
    void 증가_횟수가_다르면_다르다() {
        Count zero = Count.zero();
        Count one = zero.plusOne();
        assertNotEquals(zero, one);
    }
}
