package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NameTest {
    @Test
    public void testValidName() {
        String validName = "Car";
        Name name = new Name(validName);
        assertEquals(validName, name.toString());
    }

    @Test
    public void testExceedMaxLengthName() {
        String invalidName = "ExceedMaxName";
        assertThrows(IllegalArgumentException.class, () -> {
            new Name(invalidName);
        });
    }

    @Test
    public void testLessMinLengthName() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> {
            new Name(invalidName);
        });
    }

    @Test
    public void testNullName() {
        String invalidName = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new Name(invalidName);
        });
    }

    @Test
    public void testBlankName() {
        String invalidName = "  ";
        assertThrows(IllegalArgumentException.class, () -> {
            new Name(invalidName);
        });
    }
}
