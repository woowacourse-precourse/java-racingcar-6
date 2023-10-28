package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("정상 이름 입력")
    void readCarNames_goodInputs() {
        // given
        String inputA = "jason,bob";
        String inputB = "peter";

        // when
        System.setIn(new ByteArrayInputStream(inputA.getBytes()));
        List<Car> carsA = Game.readCarNames();

        System.setIn(new ByteArrayInputStream(inputB.getBytes()));
        List<Car> carsB = Game.readCarNames();

        // then
        assertThat(carsA.get(0).getName()).isEqualTo("jason");
        assertThat(carsA.get(1).getName()).isEqualTo("bob");
        assertThat(carsB.get(0).getName()).isEqualTo("peter");
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
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> Game.readCarNames())
            .isInstanceOf(IllegalArgumentException.class);
    }
}