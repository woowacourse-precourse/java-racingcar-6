package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.InstanceOfAssertFactories.stream;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class AskCarNameTest {

    @Test
    void 구분자_포함_확인_구분자없는경우() {
        String input = "test";
        AskCarName askCarName = new AskCarName();

        assertThat(askCarName.checkCarName(input)).isEqualTo(false);
    }

    @Test
    void 구분자_포함_확인_구분자있는경우() {
        String input = "test,game,play";
        AskCarName askCarName = new AskCarName();

        assertThat(askCarName.checkCarName(input)).isEqualTo(true);
    }

    @Test
    void 자동차_이름_길이_확인_5자미만() {
        String input = "test";
        AskCarName askCarName = new AskCarName();

        assertThat(askCarName.validateLengthOfCarName(input)).isEqualTo(true);
    }

    @Test
    void 자동차_이름_길이_확인_5자이상() {
        String input = "gamer";
        AskCarName askCarName = new AskCarName();

        assertThat(askCarName.validateLengthOfCarName(input)).isEqualTo(false);
    }

    @Test
    void split_자동차_이름_나누기_정상값() {
        String input = "test,play,game";
        Map<String, Integer> result = new HashMap<>();
        AskCarName askCarName = new AskCarName();

        result.put("test", 0);
        result.put("play", 0);
        result.put("game", 0);

        assertThat(askCarName.splitCarName(input)).isEqualTo(result);
    }

    @Test
    void split_자동차_이름_나누기_에러값() {
        String input = "test, play, gamer";
        Map<String, Integer> result = new HashMap<>();
        AskCarName askCarName = new AskCarName();

        result.put("test", 0);
        result.put("play", 0);
        result.put("gamer", 0);

        assertThatThrownBy(()-> askCarName.splitCarName(input))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
