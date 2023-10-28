package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NameTest {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int BIGGER_THAN_MAX_LENGTH = MAX_NAME_LENGTH + 1;

    @Test
    void 이름의_길이가_0이하면_예외처리() {
        // given
        String testName = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Name.from(testName);
        });
    }

    @Test
    void 이름의_길이가_최대_길이보다_크면_예외처리() {
        // given
        String testName = "t".repeat(BIGGER_THAN_MAX_LENGTH);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Name.from(testName);
        });
    }

    @Test
    void 동등성_비교_테스트() {
        // given
        String testInput = "t".repeat(MAX_NAME_LENGTH);
        Name firstName = Name.from(testInput);
        Name secondName = Name.from(testInput);

        // when & then
        assertEquals(firstName, secondName);
    }
}
