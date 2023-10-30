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
    void 입력한_이름_3개_이하_예외처리() {
        setInput("name1,name2");
        assertThatThrownBy(() -> {
            player.inputCarNames();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_이름_3개_초과_예외처리() {
        setInput("name1,name2,name3,name4");
        assertThatThrownBy(() -> {
            player.inputCarNames();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_이름_길이가_5_이상인_경우_예외처리() {
        setInput("name1,name2,namename3");
        assertThatThrownBy(() -> {
            player.inputCarNames();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    void setInput(String input) {
        System.setIn(new ByteArrayInputStream(String.join("\n", input).getBytes()));
    }
}