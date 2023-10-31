package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import jdk.jfr.ValueDescriptor;
import org.junit.jupiter.api.Test;

public class MethodTest {
    @Test
    void 자동차_공백_입력() {
        String input = "";
        assertThatThrownBy(() -> Validator.checkCarInput(input))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
