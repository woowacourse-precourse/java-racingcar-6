package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

class InputViewTest {
    private Validator validator;
    private InputView inputView;

    @Test
    public void 중복된_이름_검사() {
        List<String> carNames = List.of("안녕", "안녕", "힝구");
        validator = new Validator();
        assertTrue(validator.checkDuplicateName(carNames));
    }

    @Test
    public void 다섯자_이상_이름_검사() {
        List<String> carNames = List.of("안녕하세요", "안녕", "힝구구구구구");
        validator = new Validator();
        assertTrue(validator.checkCharacterLimit(carNames));
    }

    @Test
    public void 빈_이름_검사() {
        List<String> carNames = List.of("안녕", "", "힝구");
        validator = new Validator();
        assertTrue(validator.checkEmptyName(carNames));
    }

    @Test
    public void 정상_이름_검사() {
        List<String> carNames = List.of("포비", "뽀로로", "루피");
        validator = new Validator();
        assertFalse(validator.checkDuplicateName(carNames));
        assertFalse(validator.checkCharacterLimit(carNames));
        assertFalse(validator.checkEmptyName(carNames));
    }

    @Test
    public void 이동회수_숫자_아닌값_검사() {
        String input = "hey1"; //문자열
        inputView = new InputView();
        Assertions.assertThatThrownBy(() -> inputView.validateMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이동회수_정수가_아닌_숫자_검사() {
        String input = "1.1"; // 음수, 소수
        inputView = new InputView();
        Assertions.assertThatThrownBy(() -> inputView.validateMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_이동회수_검사() {
        String input = "5";
        inputView = new InputView();
        assertDoesNotThrow(() -> inputView.validateMoveCount(input));
    }
}