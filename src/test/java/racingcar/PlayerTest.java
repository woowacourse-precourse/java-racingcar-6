package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    private Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @AfterEach
    void clear() {
        Console.close();
    }

    @Test
    void 입력한_자동차_이름_길이_예외처리() {
        setInput("namename3");
        assertThatThrownBy(player::inputCarNames).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"one", "0"})
    void 입력한_경주_횟수_예외처리(String input) {
        setInput(input);
        assertThatThrownBy(player::inputRaceCount).isInstanceOf(IllegalArgumentException.class);
    }

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(String.join("\n", input).getBytes()));
    }
}