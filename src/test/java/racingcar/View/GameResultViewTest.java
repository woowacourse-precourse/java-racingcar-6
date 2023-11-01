package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    GameResultView gameResultView = new GameResultView();

    @Test
    @DisplayName("최종결과 출력 테스트(한 명일 때, 두 명 이상일 때)")
    public void 최종결과_출력_테스트() {
        ArrayList<String> winnerList = new ArrayList<String>();
        winnerList.add("pobi");

        gameResultView.printWinner(winnerList);
        String capturedOutput = outputStream.toString();
        assertThat(capturedOutput).isEqualTo("최종 우승자 : pobi");

        // output reset 후 우승자 두 명 이상일 때 결과 테스트
        outputStream.reset();
        winnerList.add("woni");
        winnerList.add("jun");

        gameResultView.printWinner(winnerList);
        capturedOutput = outputStream.toString();
        assertThat(capturedOutput).isEqualTo("최종 우승자 : pobi, woni, jun");
    }

}
