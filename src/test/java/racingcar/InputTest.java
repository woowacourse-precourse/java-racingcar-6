package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Input;
import racingcar.domain.Validate;

public class InputTest {
    private Input input;
    private Validate validate;

    @BeforeEach
    public void setUp() {
        validate = new Validate();
        input = new Input(validate);
    }

    @Test
    public void 이름입력의_길이가_5보다_클_때_예외() {
        // given
        String input = "veryverylong";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateName(input));
    }

    @Test
    public void 이름입력에_스페이스바가_들어있을_때_예외() {
        // given
        String input = " ss ";
        List<String> testList = Arrays.asList(" ", "s ", "   ", " a b");

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateName(input));

        for (String test : testList) {
            assertThrows(IllegalArgumentException.class, () -> validate.validateName(test));
        }
    }

    @Test
    public void 이름입력이_비어있을_때_예외() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validate.validateName(input));
    }

    @Test
    public void 시도횟수가_숫자가_아닐_때_예외() {
        // given
        List<String> testList = Arrays.asList("안녕", "huni,jun,lee", "@@!@");

        // when & then
        for (String test : testList) {
            assertThrows(IllegalArgumentException.class, () -> Validate.validateInteger(test));
        }
    }

    @Test
    public void 시도횟수가_정수가_아닐_경우_예외() {
        // given
        List<String> testList = Arrays.asList("3.154", "0.23", "6.66");

        // when & then
        for (String test : testList) {
            assertThrows(IllegalArgumentException.class, () -> validate.validateInteger(test));
        }
    }

    @Test
    public void 시도횟수가_0보다_큰_값이_아닐_경우_예외() {
        // given
        List<Integer> testList = Arrays.asList(-5, 0);

        // when & then
        for (int test : testList) {
            assertThrows(IllegalArgumentException.class, () -> validate.validatePositiveNumber(test));
        }
    }
}
