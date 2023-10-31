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

    @Test
    void 시도_횟수_올바른_형식() {
        InputValidator inputValidator = new NumberAttemptsValidator();
        assertThatCode(() -> {
            inputValidator.validate("1230");
        })
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수_숫자_아님() {
        InputValidator inputValidator = new NumberAttemptsValidator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    inputValidator.validate("NaN");
                })
                .withMessageContaining("Invalid Format");
    }

    @Test
    void 시도_횟수_음수() {
        InputValidator inputValidator = new NumberAttemptsValidator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    inputValidator.validate("-1");
                })
                .withMessageContaining("Invalid Value");
    }

    @Test
    void 시도_횟수_파싱() {
        InputParser inputParser = new NumberAttemptsParser();
        assertThat(inputParser.parse("123"))
                .isInstanceOf(Integer.class)
                .isEqualTo(123);
    }
}
