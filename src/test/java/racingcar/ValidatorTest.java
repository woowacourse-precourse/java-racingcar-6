package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator = new Validator();

    //@Test
    //void validateInput_자동차이름_입력값의길이가_1000만_이하인가() {}

    @Test
    void validateInput_입력값이_영문자_한글_쉼표로_이루어져있는지() {
        String invalidInput = "한국,pobi,MYCAR,ahn!";

        assertThatThrownBy(() -> validator.validateInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNames_자동차이름이_1자부터_5자인지_확인1() {
        List<String> invalidList = Arrays.asList("pobi", "안종혁", "");

        assertThatThrownBy(() -> validator.validateCarNames(invalidList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNames_자동차이름이_1자부터_5자인지_확인2() {
        List<String> invalidList = Arrays.asList("pobi", "안종혁", "mycars");

        assertThatThrownBy(() -> validator.validateCarNames(invalidList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNames_자동차이름이_2개이상인지_확인1() {
        List<String> invalidList = Arrays.asList("pobi");

        assertThatThrownBy(() -> validator.validateCarNames(invalidList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarNames_자동차이름이_2개이상인지_확인2() {
        List<String> validList = Arrays.asList("pobi", "종혁");

        assertThatCode(() -> validator.validateCarNames(validList))
                .doesNotThrowAnyException();
    }
}
