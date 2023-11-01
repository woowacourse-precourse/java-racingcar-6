package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.validator.CharactorLimitValidator;
import racingcar.validator.DuplicateNameValidator;
import racingcar.validator.EmptyNameValidator;
import racingcar.validator.Validator;

class InputViewTest {
    private Validator validator;

    @Test
    public void 중복된_이름_검사() {
        List<String> carNames = List.of("안녕", "안녕", "힝구");
        validator = new DuplicateNameValidator();
        assertTrue(validator.isValid(carNames));
    }

    @Test
    public void 다섯자_이상_이름_검사() {
        List<String> carNames = List.of("안녕하세요", "안녕", "힝구구구구구");
        validator = new CharactorLimitValidator();
        assertTrue(validator.isValid(carNames));
    }

    @Test
    public void 빈_이름_검사() {
        List<String> carNames = List.of("안녕", "", "힝구");
        validator = new EmptyNameValidator();
        assertTrue(validator.isValid(carNames));
    }

    @Test
    public void 정상_인풋_검사() {
        List<String> carNames = List.of("포비", "뽀로로", "루피");
        validator = new DuplicateNameValidator();
        assertFalse(validator.isValid(carNames));
    }
}