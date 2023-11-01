package tdd.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import org.junit.jupiter.api.Test;

public class InputCarNameSplitterTest {
    @Test
    void 자동차_이름_문자열_분리_검증() {
        String input = "pobi,woni,jun";

        Iterator<String> iter = InputCarNameSplitter.splitInput(input).iterator();
        assertThat("pobi").isEqualTo(iter.next());
        assertThat("woni").isEqualTo(iter.next());
        assertThat("jun").isEqualTo(iter.next());
    }
}
