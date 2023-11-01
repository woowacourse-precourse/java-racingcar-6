package racingcar;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReadLineTest {

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("정상 이름 입력(여러 개)")
    void readCarNames_goodInputs() {
        // given
        String input = "jason,bob";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Car> cars = Start.readCarNames();

        // then
        assertThat(cars.get(0).getName()).isEqualTo("jason");
        assertThat(cars.get(1).getName()).isEqualTo("bob");
    }

    @Test
    @DisplayName("정상 이름 입력(한 개)")
    void readCarNames_goodInput() {
        // given
        String input = "peter";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Car> cars = Start.readCarNames();
        Console.close();

        // then
        assertThat(cars.get(0).getName()).isEqualTo("peter");
    }

    @Test
    @DisplayName("정상 이름 입력(공백 포함)")
    void readCarNames_namesWithSpaces() {
        // given
        String input = "jason   , bob";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Car> cars = Start.readCarNames();
        Console.close();

        // then
        assertThat(cars.get(0).getName()).isEqualTo("jason");
        assertThat(cars.get(1).getName()).isEqualTo("bob");
    }

    @Test
    @DisplayName("비정상 이름 입력(쉼표만)")
    void readCarNames_onlyCommas() {
        // given
        String onlyCommas = ",,,,";

        // when - then
        System.setIn(new ByteArrayInputStream(onlyCommas.getBytes()));
        assertThatThrownBy(Start::readCarNames)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상 이름 입력(앞뒤 쉼표)")
    void readCarNames_badCommaPosition() {
        // given
        String badCommaPosition = ",lee,park,kim,";

        // when - then
        System.setIn(new ByteArrayInputStream(badCommaPosition.getBytes()));
        assertThatThrownBy(Start::readCarNames)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상 이름 입력(이름 6글자)")
    void readCarNames_sixLettersName() {
        // given
        String sixLettersName = "joshua,josh";

        // when - then
        System.setIn(new ByteArrayInputStream(sixLettersName.getBytes()));
        assertThatThrownBy(Start::readCarNames)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 게임 횟수 입력")
    void readGameCount_one() {
        // given
        String legal = "1";

        // when - then
        System.setIn(new ByteArrayInputStream(legal.getBytes()));
        int countLegal = Start.readGameCount();
        assertThat(countLegal).isEqualTo(1);
    }

    @Test
    @DisplayName("비정상 게임 횟수 입력(0)")
    void readGameCount_zero() {
        checkGameCount("0");
    }

    @Test
    @DisplayName("비정상 게임 횟수 입력(-1)")
    void readGameCount_minusOne() {
        checkGameCount("-1");
    }

    @Test
    @DisplayName("비정상 게임 횟수 입력(숫자 아닌 문자 포함)")
    void readGameCount_noDigit() {
        checkGameCount("12a");
    }

    private static void checkGameCount(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Start::readGameCount)
            .isInstanceOf(IllegalArgumentException.class);
    }
}