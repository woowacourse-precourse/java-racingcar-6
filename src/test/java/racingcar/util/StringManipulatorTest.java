package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.Constants.INPUT_SEPARATOR;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringManipulatorTest {

    @Test
    void splitSeparator() {
        String sentence = "pobi,woni,jun";

        String[] names = StringManipulator.splitSeparator(sentence, INPUT_SEPARATOR);
        String name1 = names[0];
        String name2 = names[1];
        String name3 = names[2];

        assertThat(name1).isEqualTo("pobi");
        assertThat(name2).isEqualTo("woni");
        assertThat(name3).isEqualTo("jun");
    }

    @Test
    void toList() {
        String[] names = {"pobi", "woni", "jun"};

        List<String> convertedNames = StringManipulator.toList(names);

        assertThat(convertedNames).containsExactly("pobi", "woni", "jun");
    }
}