package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("정상 이름 입력")
    void readCarNames_goodInputs() {
        String inputA = "jason,bob";
        String inputB = "peter";

        // inputA
        InputStream in = new ByteArrayInputStream(inputA.getBytes());
        System.setIn(in);
        List<Car> cars = Game.readCarNames();

        assertThat(cars.get(0).getName()).isEqualTo("jason");
        assertThat(cars.get(1).getName()).isEqualTo("bob");

        // inputB
        in = new ByteArrayInputStream(inputB.getBytes());
        System.setIn(in);
        cars = Game.readCarNames();

        assertThat(cars.get(0).getName()).isEqualTo("peter");
    }

    @Test
    @DisplayName("비정상 이름 입력")
    void readCarNames_badInputs() {
        String onlyCommas = ",,,,";
        String badCommaPosition = ",lee,park,kim,";
        String sixLettersName = "joshua,josh";

        testBadInput(onlyCommas);
        testBadInput(badCommaPosition);
        testBadInput(sixLettersName);
    }

    private static void testBadInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> Game.readCarNames())
            .isInstanceOf(IllegalArgumentException.class);
    }
}