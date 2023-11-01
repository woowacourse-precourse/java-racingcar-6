package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.utils.Util;

public class UtilTest {

    @Test
    void 공백_제거() {
        String stringWithSpace = " a b c ";
        String result = Util.removeSpace(stringWithSpace);
        assertThat(result).isEqualTo("abc");
    }
}