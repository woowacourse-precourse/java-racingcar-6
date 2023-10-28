package racingcar.viewTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vIew.OutputView;

public class OutputTest {
    private static final String gameResultOutputMessage = "실행 결과";
    private static final String WinngerOutputMessage = "최종 우승자 : ";
    private static ByteArrayOutputStream output;

    @BeforeEach
    public void setUpStreams() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("게임결과 메세지 출력 테스트 ")
    void 게임결과_메세지_출력_테스트() {
        OutputView.gameResultMessageOutput();
        assertThat(gameResultOutputMessage).isEqualTo(output.toString().trim());
    }

    @Test
    @DisplayName("게임결과 출력 테스트 ")
    void 게임결과_출력_테스트() {
        LinkedHashMap<String, String> gameResult = new LinkedHashMap<>();
        gameResult.put("pobi", "-");
        gameResult.put("woni", "---");
        gameResult.put("jun", "---");

        OutputView.gameReslutOutput(gameResult);
        String expectResult = "pobi : -" + System.lineSeparator() + "woni : ---" + System.lineSeparator() + "jun : ---";

        assertThat(expectResult).isEqualTo(output.toString().trim());

    }

    @Test
    @DisplayName("단독우승자 출력 테스트 ")
    void 단독우승자_출력_테스트() {
        List<String> winners = new ArrayList<>(Arrays.asList("pobi"));

        OutputView.WinnerOutput(winners);

        assertThat("최종 우승자 : pobi").isEqualTo(output.toString());
    }

    @Test
    @DisplayName("공동우승자 출력 테스트 ")
    void 공동우승자_출력_테스트() {
        List<String> winners = new ArrayList<>(Arrays.asList("pobi", "jun"));

        OutputView.WinnerOutput(winners);

        assertThat(WinngerOutputMessage + "pobi, jun").isEqualTo(output.toString().trim());
    }
}
