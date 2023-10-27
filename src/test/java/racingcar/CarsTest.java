package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class CarsTest {

    @Test
    void Cars는_하나_이상의_Car를_가지지_않는경우_예외를_던진다() {
        String input = ",";

        assertThrows(IllegalArgumentException.class, () -> Cars.create(input));
    }

    @Test
    void 사용자가_6자이상의_이름을_입력한경우_예외를_던진다(){
        String input = "여섯글자이상,다섯자이름,일";

        assertThrows(IllegalArgumentException.class, () -> Cars.create(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi,woni,jun", "pobi,,woni,jun", "pobi,woni,jun,", "pobi,woni,jun,,"})
    void 사용자가_1자_미만의_이름을_입력한경우_예외를_던진다(String target) {
        assertThrows(IllegalArgumentException.class, () -> Cars.create(target));
    }

    @Test
    void 중복되는_이름이_있는_경우_예외를_던진다() {
        String input = "pobi,pobi";

        assertThrows(IllegalArgumentException.class, () -> Cars.create(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "aaa", "aaaaa"})
    void Cars_생성시_요구사항에_맞는_이름을_입력하면_예외가_던져지지_않는다(String target) {
        assertDoesNotThrow(() -> Cars.create(target));
    }

}
