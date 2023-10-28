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
        // given
        String onlyCommas = ",,,,";
        String badCommaPosition = ",lee,park,kim,";
        String sixLettersName = "joshua,josh";

        // when - then
        System.setIn(new ByteArrayInputStream(onlyCommas.getBytes()));
        assertThatThrownBy(() -> Game.readCarNames())
            .isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(badCommaPosition.getBytes()));
        assertThatThrownBy(() -> Game.readCarNames())
            .isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(sixLettersName.getBytes()));
        assertThatThrownBy(() -> Game.readCarNames())
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("게임 횟수 입력")
    void readGameCount() {
        // given
        String legal = "1";
        String illegal1 = "-1";
        String illegal2 = "a123";

        // when - then
        System.setIn(new ByteArrayInputStream(legal.getBytes()));
        int countLegal = Game.readGameCount();
        assertThat(countLegal).isEqualTo(1);

        System.setIn(new ByteArrayInputStream(illegal1.getBytes()));
        assertThatThrownBy(Game::readGameCount)
            .isInstanceOf(IllegalArgumentException.class);

        System.setIn(new ByteArrayInputStream(illegal2.getBytes()));
        assertThatThrownBy(Game::readGameCount)
            .isInstanceOf(IllegalArgumentException.class);
    }
}