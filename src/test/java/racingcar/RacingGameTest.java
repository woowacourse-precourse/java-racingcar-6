package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    private static ByteArrayOutputStream printResult;
    @BeforeEach
    void setUpStreams() {
        printResult = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printResult));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("ifNumIsOver4 함수로 랜덤 숫자가 4 이상이면 전진, 4 미만이면 정지")
    void ifNumIsOver4Happy() {
        //given
        List<Integer> randomNumList = new ArrayList<Integer>(Arrays.asList(1,4,6));
        List<String> gameSituation = new ArrayList<String>(Arrays.asList("-","",""));

        //when
        List<String> result = RacingGame.ifNumIsOver4(randomNumList, gameSituation);

        //then
        Assertions.assertThat(result).containsExactly("-","-","-");

    }

    @Test
    @DisplayName("move함수로 올바른 차량에 '-' 가 추가되는지 확인")
    void move() {
        //given
        List<String> gameSituation = new ArrayList<String>(Arrays.asList("","","",""));
        int index = 2;

        //when
        List<String> result = RacingGame.move(gameSituation, index);

        //then
        Assertions.assertThat(result).containsExactly("","","-","");
    }

    @Test
    @DisplayName("printRaceSituation 함수로 경주 현황을 출력할 수 있다")
    void printRaceSituation() {
        //given
        List<String> carList = new ArrayList<String>(Arrays.asList("aa","bb","cc"));
        List<String> gameSituation = new ArrayList<String>(Arrays.asList("-","--",""));

        //when
        RacingGame.printRaceSituation(carList,gameSituation);

        //then
        assertEquals("aa : -\nbb : --\ncc : \n\n", printResult.toString());
    }

}