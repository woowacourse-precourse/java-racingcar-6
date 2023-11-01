package racingcar.domain.car;

import exception.WrongNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    @DisplayName("이름은 정상적으로 생성되어야 한다.")
    void Name_정상적으로_생성() {
        Name name = new Name("First");

        assertEquals("First", name.value());
    }

    @Test
    @DisplayName("이름은 5글자가 넘으면 생성이 되지 않는다.")
    void Name_5글자_초과하면_익셉션_발생() {
        assertThrows(WrongNameException.class, () -> new Name("abcdef"));
    }

    @Test
    @DisplayName("빈 이름은 생성될 수 없다.")
    void Name_빈글자_익셉션_발생() {
        assertThrows(WrongNameException.class, () -> new Name(""));
    }
}