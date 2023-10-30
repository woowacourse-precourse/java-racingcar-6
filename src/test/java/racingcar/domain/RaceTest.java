package racingcar.domain;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    Race race = new Race();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 단일_우승자_추출() {
        // given
        List<String> names = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List<Integer> movementList = Arrays.asList(4, 5, 4, 3);
        int moveCount = 5;

        // when
        List<String> winners = race.extractWinner(names, movementList, moveCount);

        // then
        assertThat(winners).containsExactly("bbb");
    }

    @Test
    void 여러_우승자_추출() {
        // given
        List<String> names = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List<Integer> movementList = Arrays.asList(4, 3, 4, 2);
        int moveCount = 4;

        // when
        List<String> winners = race.extractWinner(names, movementList, moveCount);

        // then
        assertThat(winners).containsExactly("aaa", "ccc");
    }

    @Test
    void 단일_우승자_출력() {
        // given
        List<String> names = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List<Integer> movementList = Arrays.asList(4, 5, 4, 3);
        int moveCount = 5;

        // when
        race.printWinner(names, movementList, moveCount);
        String expectedPrintWinnerFormat = "최종 우승자 : bbb\n";

        // then
        assertThat(output.toString()).isEqualTo(expectedPrintWinnerFormat);
    }

    @Test
    void 여러_우승자_출력() {
        // given
        List<String> names = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List<Integer> movementList = Arrays.asList(4, 2, 3, 4);
        int moveCount = 4;

        // when
        race.printWinner(names, movementList, moveCount);
        String expectedPrintWinnerFormat = "최종 우승자 : aaa, ddd\n";

        // then
        assertThat(output.toString()).isEqualTo(expectedPrintWinnerFormat);
    }
}