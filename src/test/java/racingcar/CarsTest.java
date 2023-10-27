package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

final class CarsTest {

    @Test
    void Cars는_하나_이상의_Car를_가지지_않는경우_예외를_던진다() {
        String input = ",";

        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }

    @Test
    void 사용자가_6자이상의_이름을_입력한경우_예외를_던진다(){
        String input = "여섯글자이상,다섯자이름,일";

        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }

    @Test
    void 사용자가_1자_미만의_이름을_입력한경우_예외를_던진다() {
        String input = ",pobi,woni,jun";

        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }

    @Test
    void 중복되는_이름이_있는_경우_예외를_던진다() {
        String input = "pobi,pobi";

        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }

}
