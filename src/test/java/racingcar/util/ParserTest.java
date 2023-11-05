package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ParserTest extends NsTest{

    Parser parser = new Parser();

    @Test
    void 횟수_숫자_반환() {
        int numTrial = parser.parseNumGames("5");
        assertThat(numTrial).isEqualTo(5);
    }

    @Test
    void 자동차_이름_리스트_반환() {
        List<String> carNames = parser.parseCarNames("a,b,c");
        assertThat(carNames).containsExactly("a", "b", "c");
    }


    @Override
    protected void runMain() {
    }
}
