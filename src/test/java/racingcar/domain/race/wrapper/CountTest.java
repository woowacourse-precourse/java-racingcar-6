package racingcar.domain.race.wrapper;

import org.junit.jupiter.api.Test;
import racingcar.constants.ErrorConsts;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountTest {

    @Test
    void 생성자에_음수_전달시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Count("-1"), ErrorConsts.INSUFFICIENT_RACE_COUNT.getFormattedMessage(1));
    }

    @Test
    void 생성자에서_Integer_파싱_오류시_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new Count("abc"), ErrorConsts.NOT_NUMBER_FORMATTED.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Count("1.1"), ErrorConsts.NOT_NUMBER_FORMATTED.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Count("123123123123123213123123123123123123"), ErrorConsts.NOT_NUMBER_FORMATTED.getMessage());
    }

    @Test
    void decrease_후_isOver_여부_확인() {
        Count count = new Count("2");
        count.decrease();
        assertFalse(count.isOver());
        count.decrease();
        assertTrue(count.isOver());
    }
}
