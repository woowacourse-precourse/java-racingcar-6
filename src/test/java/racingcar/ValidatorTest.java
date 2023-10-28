package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void 차이름_6자이상() {
        String inputCarNames = "123456,qwer,asd,zzz";
        List<String> carNames = Arrays.asList(inputCarNames.split(","));
        Validator validator = new Validator();
        boolean isValid = validator.isValidCarNames(carNames);
        Assertions.assertThat(isValid).isEqualTo(Boolean.FALSE);
    }

    @Test
    void 차이름_5자이하() {
        String inputCarNames = "123,qwer,asdf,zx";
        List<String> carNames = Arrays.asList(inputCarNames.split(","));
        Validator validator = new Validator();
        boolean isValid = validator.isValidCarNames(carNames);
        Assertions.assertThat(isValid).isEqualTo(Boolean.TRUE);
    }

    @Test
    void 전진횟수_문자입력() {
        String inputMoveCount = "testInput";
        Validator validator = new Validator();
        boolean isValid = validator.isValidTryCount(inputMoveCount);
        Assertions.assertThat(isValid).isEqualTo(Boolean.FALSE);
    }

    @Test
    void 전진횟수_숫자입력() {
        String inputMoveCount = "123";
        Validator validator = new Validator();
        boolean isValid = validator.isValidTryCount(inputMoveCount);
        Assertions.assertThat(isValid).isEqualTo(Boolean.TRUE);
    }
}