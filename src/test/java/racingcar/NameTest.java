package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

final class NameTest {

    @Test
    void 자동차이름의_길이가_1_미만일_경우_예외를_터트린다() {
        assertThrows(IllegalArgumentException.class, () -> new Name(""));
    }

    @Test
    void 자동차이름의_길이가_5_초과일_경우_예외를_터트린다() {
        assertThrows(IllegalArgumentException.class, () -> new Name("다섯글자이상"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    void 자동차이름의_길이가_1이상_5이하일_경우_예외가_발생하지_않는다(String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    void 동일한_이름은_동일한_객체로_인식된다() {
        Name name1 = new Name("동일한이름");
        Name name2 = new Name("동일한이름");

        assertEquals(name1, name2);
    }

    @Test
    void 동일한_이름은_Hash_자료구조에서도_동일한_객체로_인식된다() {
        Name name1 = new Name("동일한이름");
        Name name2 = new Name("동일한이름");
        Set<Name> set = new HashSet<>();

        set.add(name1);
        set.add(name2);

        assertEquals(1, set.size());
    }
}
