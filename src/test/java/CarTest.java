import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void isCarNameLengthOver_자동차_이름_5글자_이상() {

        String input = "aasdaa";

        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isCarNameNull_자동차_이름_null() {

        String input = null;

        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isCarNameBlank_자동차_이름_빈문자열() {

        String input = "";

        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNotAlphaBetAndComma_자동차_이름_공백으로_이루어짐() {

        String input = "  ";

        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNotAlphaBetAndComma_자동차_이름_문자가_아닌_경우() {

        String input = "123";

        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
