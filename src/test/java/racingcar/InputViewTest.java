package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 플레이어_이름_입력_확인() {
        setInput("aaa,bbb,ccc");

        List<String> validPlayerList = inputView.inputPlayerList();
        assertThat(validPlayerList).contains("aaa", "bbb", "ccc");
    }

    @Test
    void 플레이어_이름_길이_예외_처리() {
        setInput("aaa,aaaaa,aaaaaa,aaaaaaa");

        assertThatThrownBy(() -> inputView.inputPlayerList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputView.PLAYER_NAME_ERROR);
    }

    @Test
    void 플레이어_이름_공백_처리() {
        setInput("\n");

        assertThatThrownBy(() -> inputView.inputPlayerList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputView.PLAYER_EMPTY_ERROR);
    }

    @Test
    void 게임_횟수_입력_확인() {
        setInput("12");

        int validGameCount = inputView.inputGameCount();
        assertThat(validGameCount).isEqualTo(12);
    }

    @Test
    void 게임_횟수_숫자외_예외_처리() {
        setInput("12AB");

        assertThatThrownBy(() -> inputView.inputGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputView.GAME_COUNT_ERROR);
    }

    @Test
    void 게임_횟수_1미만_예외_처리() {
        setInput("000");

        assertThatThrownBy(() -> inputView.inputGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputView.GAME_COUNT_ERROR);
    }
}
