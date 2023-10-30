package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 실행_결과_출력_테스트() {
        GameResult gameResult = new GameResult();
        final List<String> nameList = new ArrayList<>(List.of("pobi", "woni", "jun"));
        final List<Integer> scoreList = new ArrayList<>(List.of(1, 4, 3));

        gameResult.setCarsNameList(nameList);
        gameResult.singleAttemptResult(scoreList);

        assertThat(outputMessage.toString())
                .isEqualTo("pobi : -\n"
                        + "woni : ----\n"
                        + "jun : ---\n\n");
    }

    @Test
    void 우승자_출력_테스트() {
        GameResult gameResult = new GameResult();
        final List<String> nameList = new ArrayList<>(List.of("pobi", "woni", "jun"));
        final List<Integer> scoreList = new ArrayList<>(List.of(1, 4, 3));

        gameResult.setCarsNameList(nameList);
        gameResult.printWinner(scoreList);

        assertThat(outputMessage.toString())
                .isEqualTo("최종 우승자 : woni");
    }

    @Test
    void 단독_우승_리스트_최댓값의_인덱스_추출() {
        GameResult gameResult = new GameResult();
        final List<Integer> list = new ArrayList<>(List.of(1, 4, 3));

        assertThat(gameResult.findIndexOfWinner(list))
                .containsExactly(1);
    }

    @Test
    void 공동_우승_리스트_최댓값의_인덱스_추출() {
        GameResult gameResult = new GameResult();
        final List<Integer> list = new ArrayList<>(List.of(1, 4, 3, 4));

        assertThat(gameResult.findIndexOfWinner(list))
                .containsExactly(1, 3);
    }

}