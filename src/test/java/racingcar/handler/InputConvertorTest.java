package racingcar.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputConvertorTest {

    @Test
    public void 쉼표로_문자열을_분리하면_올바르게_분리된_리스트가_반환되어야_한다() {
        String input = "car1,car2,car3";
        List<String> expected = List.of("car1", "car2", "car3");

        List<String> result = InputConvertor.splitByComma(input);

        assertEquals(expected, result);
    }

    @Test
    public void 유효한_문자열을_정수로_변환하면_올바른_정수가_반환되어야_한다() {
        String input = "12345";

        int result = InputConvertor.convertToInt(input);

        assertEquals(12345, result);
    }

    @Test
    public void 유효하지_않은_문자열을_정수로_변환하려고_하면_NumberFormatException이_발생해야_한다() {
        String input = "invalid";

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputConvertor.convertToInt(input));
    }
}
