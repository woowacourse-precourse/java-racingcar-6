package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultByRaceTest {
    private ResultByRace resultByRace;

    @BeforeEach
    void setUp() {
        resultByRace = new ResultByRace();
    }

    @DisplayName("시도 회수를 정상 입력한 경우")
    @Test
    void askPlayTimeWithValidInput() {
        System.setIn(createUserInput(3));

        resultByRace.askPlayTime();

        assertThat(resultByRace.getFinalRound()).isEqualTo(3);
    }

    @DisplayName("시도 회수에 문자열을 입력한 경우")
    @Test
    void askPlayTimeWithStringInput() {
        System.setIn(createUserInput("숫자가 아님"));

        assertThrows(IllegalArgumentException.class, () -> resultByRace.askPlayTime());
    }
    @DisplayName("시도 회수에 0 이하를 입력한 경우")
    @Test
    void askPlayTimeWithNonPositiveInput() {
        System.setIn(createUserInput("0"));

        assertThrows(IllegalArgumentException.class, () -> resultByRace.askPlayTime());
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    InputStream createUserInput(int input) {
        return new ByteArrayInputStream(String.valueOf(input).getBytes());
    }
}
