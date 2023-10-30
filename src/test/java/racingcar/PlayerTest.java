package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 입력한_이름_길이가_5_이상인_경우_예외처리() {
        setInput("name1,name2,namename3");
        assertThatThrownBy(() -> {
            player.inputCarNames();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_경주_횟수가_숫자가_아닌_경우_예외처리() {
        setInput("one");
        assertThatThrownBy(() -> {
            player.inputRaceCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_경주_횟수가_1이상이_아닌_경우_예외처리() {
        setInput("0");
        assertThatThrownBy(() -> {
            player.inputRaceCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(String.join("\n", input).getBytes()));
    }
}