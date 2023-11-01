package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameValidatorTest {

    @Test
    void 자동차_이름의_길이가_5를_초과하면_에러를_발생시킨다() {
        String carName = "가나다라마바사";
        assertThrows(IllegalArgumentException.class, () ->
                GameValidator.validationCarNameLength(carName)
        );
    }

    @Test
    void 자동차_이름의_길이가_5를_미만이면_에러를_발생시키지_않는다() {
        String carName = "도모";
        assertDoesNotThrow(() -> GameValidator.validationCarNameLength(carName));
    }

    @Test
    void 이동회수를_입력받을때_문자라면_에러를_발생시킨다() {
        String moveCnt = "문자데이터";
        assertThrows(IllegalArgumentException.class, () ->
                GameValidator.validationMoveCntIsNumber(moveCnt)
        );
    }

    @Test
    void 이동회수를_입력받을때_음수값이라면_에러를_발생시킨다() {
        String moveCnt = "-2";
        assertThrows(IllegalArgumentException.class, () ->
                GameValidator.validationMoveCntIsNumber(moveCnt)
        );
    }

    @Test
    void 이동회수를_입력받을때_실수값이라면_에러를_발생시킨다() {
        String moveCnt = "0.3";
        assertThrows(IllegalArgumentException.class, () ->
                GameValidator.validationMoveCntIsNumber(moveCnt)
        );
    }


    @Test
    void 이동회수를_입력받을때_숫자라면_에러를_발생시키지_않는다() {
        String moveCnt = "1234";
        assertDoesNotThrow(() -> GameValidator.validationMoveCntIsNumber(moveCnt));
    }
}