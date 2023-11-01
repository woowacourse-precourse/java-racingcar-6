package model;

import static model.ErrorMessage.INVALID_NAME_LENGTH;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "EXCEEDED_NAME"})
    void 이름의_길이가_유효하지_않을_때__예외처리(final String name) {
        // when & then
        assertAll(() -> {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    Name.from(name);
                });
            assertEquals(INVALID_NAME_LENGTH.getMessage(), exception.getMessage());
        });
    }
}
