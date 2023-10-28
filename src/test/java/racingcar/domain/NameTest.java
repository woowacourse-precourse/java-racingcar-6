package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    public void 인가된_이름_처리() {
        String validName = "woni";
        Name name = new Name(validName);
        Assertions.assertEquals(validName, name.toString());
    }

    @Test
    void 이름의_길이에_대한_예외_처리() {
        String invalidName = "TooLongName";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }
}
