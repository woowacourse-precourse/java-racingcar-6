package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

final class CountTest {

    @Test
    void 시도_횟수가_숫자가_아닐경우_예외를_던진다() {
        assertThrows(IllegalArgumentException.class, () -> Count.create("a"));
    }

}
