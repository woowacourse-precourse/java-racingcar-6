package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GameResultTest {
    private GameResult gameResult;
    private static ByteArrayOutputStream outputMessage;
    final List<Map.Entry<String, Integer>> scoreEntryList = new ArrayList<>();

    private List<Map.Entry<String, Integer>> getScoreEntryList(String[] nameArr, Integer[] scoreArr) {
        final List<String> nameList = Arrays.asList(nameArr);
        final List<Integer> scoreList = Arrays.asList(scoreArr);

        for(int i=0; i<nameList.size(); i++) {
            scoreEntryList.add(new AbstractMap.SimpleEntry<>(nameList.get(i), scoreList.get(i)));
        }
        return scoreEntryList;
    }

    @BeforeEach
    void setUpStreams() {
        gameResult = new GameResult();
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 실행_결과_출력_테스트() {
        String[] nameArr = {"pobi", "woni", "jun"};
        Integer[] scoreArr = {1, 4, 3};

        gameResult.singleAttemptResult(getScoreEntryList(nameArr, scoreArr));

        assertThat(outputMessage.toString())
                .isEqualTo("pobi : -\n"
                        + "woni : ----\n"
                        + "jun : ---\n\n");
    }

    @Test
    void 우승자_출력_테스트() {
        String[] nameArr = {"pobi", "woni", "jun"};
        Integer[] scoreArr = {1, 2, 4};

        gameResult.printWinner(getScoreEntryList(nameArr, scoreArr));

        assertThat(outputMessage.toString())
                .isEqualTo("최종 우승자 : jun");
    }

    @Test
    void 단독_우승_리스트_최댓값의_인덱스_추출() {
        String[] nameArr = {"pobi", "woni", "jun"};
        Integer[] scoreArr = {5, 2, 4};

        assertThat(gameResult.findIndexOfWinner(getScoreEntryList(nameArr, scoreArr)))
                .containsExactly(0);
    }

    @Disabled
    void 공동_우승_리스트_최댓값의_인덱스_추출() {
        String[] nameArr = {"pobi", "woni", "jun", "hyeok"};
        Integer[] scoreArr = {5, 2, 4, 5};

        assertThat(gameResult.findIndexOfWinner(getScoreEntryList(nameArr, scoreArr)))
                .containsExactly(0, 3);
    }
}