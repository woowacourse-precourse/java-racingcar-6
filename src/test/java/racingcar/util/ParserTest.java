package racingcar.util;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    @Test
    void 이동횟수_문자_입력(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Parser.tryCount("a"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
}
