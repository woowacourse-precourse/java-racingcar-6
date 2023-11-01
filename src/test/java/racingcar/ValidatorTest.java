package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class ValidatorTest {

    @Test
    public void 유효한_숫자_검증() throws Exception{
        String input = "a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumbers(input);
        });
    }

    @Test
    public void 중복_이름_검증() throws Exception{
        String[] names = {"brian", "poby", "brian"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateDuplicateName(names);
        });
    }

    @Test
    public void 유효한_이름_검증() throws Exception{
        String name = "yoo~!";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateName(name);
        });
    }

    @Test
    public void 유효한_이름_길이_검증() throws Exception{
        String name = "andres";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNameLength(name);
        });
    }

    @Test
    public void 연이은_쉼표_검증() throws Exception{
        String alignedNames = "brian,poby,,jake";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateConsecutiveCommas(alignedNames);
        });
    }
}
