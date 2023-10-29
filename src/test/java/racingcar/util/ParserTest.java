package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ParserTest extends NsTest{

    Parser parser = new Parser();

    @Test
    void 횟수_검증_성공_후_횟수_숫자_반환() {
        int numTrial = parser.parseNumTrial("5");
        assertThat(numTrial).isEqualTo(5);
    }

    @Test
    void 자동차_이름_검증_성공_후_자동차_이름_리스트_반환() {
        List<String> carNames = parser.parseCarNames("a,b,c");
        assertThat(carNames).containsExactly("a", "b", "c");
    }

    @Test
    void 자동차_이름_오류_발생시_예외_발생() {
        assertThatThrownBy(() -> parser.parseCarNames("a,,b"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_오류_발생시_예외_발생() {
        assertThatThrownBy(() -> parser.parseNumTrial("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
    }
}
