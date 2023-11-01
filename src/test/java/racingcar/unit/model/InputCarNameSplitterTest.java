package racingcar.unit.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.config.RacingConfig.CAR_NAME_SPLIT_DELIM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.InputCarNameSplitter;

public class InputCarNameSplitterTest {
    @Test
    void 분리된_자동차_이름이_모두_일치하면_통과() {
        InputCarNameSplitter splitter = new InputCarNameSplitter();
        String input = "pobi,woni,jun";

        Iterator<String> iter = splitter.splitInputCarNames(input).iterator();
        assertThat("pobi").isEqualTo(iter.next());
        assertThat("woni").isEqualTo(iter.next());
        assertThat("jun").isEqualTo(iter.next());
    }

    @Test
    void 분리된_자동차_이름이_하나라도_다르면_통과() {
        InputCarNameSplitter splitter = new InputCarNameSplitter();
        String input = "pobi,woni,jun";

        Iterator<String> iter = splitter.splitInputCarNames(input).iterator();
        assertThat("pobi").isEqualTo(iter.next());
        assertThat("woninini").isNotEqualTo(iter.next());
        assertThat("jun").isEqualTo(iter.next());
    }

    @Test
    void 분리된_자동차_이름이_모두_다르면_통과() {
        InputCarNameSplitter splitter = new InputCarNameSplitter();
        String input = "pobi,woni,jun";

        Iterator<String> iter = splitter.splitInputCarNames(input).iterator();
        assertThat("pobi쿤").isNotEqualTo(iter.next());
        assertThat("woni쿤").isNotEqualTo(iter.next());
        assertThat("jun쿤").isNotEqualTo(iter.next());
    }
}
