package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameViewTest {
    @Test
    void 자동차_이름_올바른_형식() {
        InputValidator inputValidator = new CarNamesValidator();
        assertThatCode(() -> {
            inputValidator.validate("t,t1,T3S,Test,T2st0");
        })
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_쉼표_예외처리() {
        InputValidator inputValidator = new CarNamesValidator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    inputValidator.validate(",test1,test2");
                })
                .withMessageContaining("Invalid Format");
    }

    @Test
    void 자동차_이름_6자_이상() {
        InputValidator inputValidator = new CarNamesValidator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    inputValidator.validate("Test,Tester");
                })
                .withMessageContaining("Invalid Format");
    }

    @Test
    void 자동차_이름_파싱() {
        InputParser inputParser = new CarNamesParser();
        assertThat(inputParser.parse("t,t1,T3S,Test,T2st0"))
                .isInstanceOf(List.class)
                .asList()
                .contains("t", "t1", "T3S", "Test", "T2st0");
    }
}
