package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Player;

class RacingCarGameViewTest {

    private RacingCarGameView racingCarGameView;
    private ByteArrayOutputStream outputStream;

    protected InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    protected String getOutput() {
        return outputStream.toString();
    }

    @BeforeEach
    void setUp() {
        racingCarGameView = new RacingCarGameView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void closeConsole() {
        Console.close();
        System.setOut(System.out);
    }

    @Test
    void requestCarName() {
        System.setIn(createInput("a,b,c"));

        Assertions.assertThat(racingCarGameView.requestCarName()).isEqualTo(List.of("a", "b", "c"));
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outputStream.toString());
    }

    @Test
    void requestTryNumber() {
        System.setIn(createInput("10"));

        Assertions.assertThat(racingCarGameView.requestTryNumber()).isEqualTo(10);
        assertEquals("시도할 회수는 몇회인가요?\n\n", outputStream.toString());
    }

    @Test
    void gameResult() {
        racingCarGameView.gameResult();
        assertEquals("실행 결과\n", outputStream.toString());
    }

    @Test
    void showNowPlayerLocation() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("a", 0));
        playerList.add(new Player("b", 1));
        playerList.add(new Player("c", 2));
        racingCarGameView.showNowPlayerLocation(playerList);

        assertEquals("a : \nb : -\nc : --\n\n", outputStream.toString());
    }

    @Test
    void showGameWinner() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("a", 0));
        playerList.add(new Player("b", 1));

        racingCarGameView.showGameWinner(playerList);

        assertEquals("최종 우승자 : a, b\n", outputStream.toString());
    }

    @Test
    void validName() {
        String name = "abcdef";

        assertThatThrownBy(() -> racingCarGameView.validName(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void showLocation() {
        int location = 3;

        racingCarGameView.showLocation(location);
        
        assertEquals("---", outputStream.toString());
    }

}