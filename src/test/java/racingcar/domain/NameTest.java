package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    public void test_validName() {
        String validName = "Valid";
        Name name = new Name(validName);

        assertEquals(validName, name.toString());
    }

    @Test
    void test_nameLength_Exception() {
        String invalidName = "TooLongName";

        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }
    @Test
    void test_name_is_null() {
        String invalidName = null;

        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }
}
