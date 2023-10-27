package racingcar.gameutil;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.GameUtil;

class GameUtilTest {

    @Test
    void splitByCommasTest() {
        // given
        String input = "pobi,woni,jun";
        // when
        List<String> result = GameUtil.splitByCommas(input);
        // then
        Assertions.assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void splitByCommasTest2() {
        // given
        String input = "p,o,b,i";
        // when
        List<String> result = GameUtil.splitByCommas(input);
        // then
        Assertions.assertThat(result).containsExactly("p", "o", "b", "i");
    }
}