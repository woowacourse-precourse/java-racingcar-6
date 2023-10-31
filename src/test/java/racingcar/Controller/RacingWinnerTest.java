package racingcar.Controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class RacingWinnerTest {
    private static RacingWinner racingWinner;

    @BeforeAll
    public static void setup() {
        racingWinner = new RacingWinner();
    }

    @Test
    @DisplayName("car 이름 테스트")
    void findWinner() {
        //given
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("hi", "--");
        inputMap.put("ho", "----");
        inputMap.put("hoot", "-");

        //when
        final int winner = racingWinner.findWinner(inputMap);

        //then
        assertThat(winner).isEqualTo(4);
    }

    @Test
    @DisplayName("단일 우승자 테스트")
    void printSingleWinner() {
        //given
        Map<String, String> list = new HashMap<>();
        list.put("hi", "-");
        list.put("ho", "---");
        list.put("hoot", "-");
        int maxLength = 3;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        racingWinner.printRaceWinner(list, maxLength);

        assertThat(outContent.toString().trim()).isEqualTo("최종 우승자 : ho");

    }

    @Test
    void printWinners() {
        //given
        Map<String, String> list = new HashMap<>();
        list.put("hi", "---");
        list.put("ho", "---");
        list.put("do", "-");
        int maxLength = 3;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        racingWinner.printRaceWinner(list, maxLength);

        assertThat(outContent.toString().trim()).isEqualTo("최종 우승자 : hi, ho");
    }
}