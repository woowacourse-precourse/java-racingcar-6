package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validate.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InvalidInputExceptionTest {
    InvalidInputException invalidInputException = new InvalidInputException();

    @Test
    void 자동차_이름_null_예외_처리() {
        String inputName = null;
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null입니다.");
    }

    @Test
    void 자동차_이름_공백_예외_처리() {
        String inputName = ",pobi";
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 한 글자 이상이어야 합니다.");
    }

    @Test
    void 자동차_이름_1개_예외_처리() {
        String inputName = "pobi,";
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 2대 이상 있어야만 경주가 가능합니다.");
    }

    @Test
    void 자동차_이름_중복_예외_처리() {
        String inputName = "pobi,pobi";
        assertThatThrownBy(() -> {
            invalidInputException.checkCarNames(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("동일한 자동차 이름을 여러번 입력할 수 없습니다.");
    }

    @Test
    void 이동_시도_횟수_숫자가_아닌_예외_처리() {
        String inputTimes = "abc";
        assertThatThrownBy(() -> {
            invalidInputException.checkTimes(inputTimes);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 이동_시도_횟수_1미만_예외_처리() {
        String inputTimes = "0";
        assertThatThrownBy(() -> {
            invalidInputException.checkTimes(inputTimes);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 시도 횟수는 1이상이어야 합니다.");
    }

}
