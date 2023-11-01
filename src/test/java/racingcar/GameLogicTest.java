package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameLogicTest {

    @Test
    void 우승자_확인_테스트() {
        GameLogic gameLogic = new GameLogic();
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        gameLogic.initializeProgress(carNames.size());
        List<String> progresses = Arrays.asList("--", "---", "---");
        gameLogic.progresses = new ArrayList<>(progresses);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        gameLogic.findWinner(carNames);
        String consoleOutput = outputStream.toString();
        assertThat(consoleOutput).contains("최종 우승자 : woni, jun");
        System.setOut(originalOut);
    }

    @Test
    void 진행_상황_계산_테스트() {
        GameLogic gameLogic = new GameLogic();
        String progress = "--";
        int count = gameLogic.countProgress(progress);
        assertThat(count).isEqualTo(2);
    }
}
