package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GrandprixTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void initTest() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void playGrandprixTest() {
        //given
        Grandprix grandprix = new Grandprix();

        List<String> testPlayers = new ArrayList();
        Map<String, Car> testCars = new HashMap<>();
        int numberOfTestPlayer = 12;
        int numberOfTestTry = 12;

        //when
        for (int i = 0; i < numberOfTestPlayer; i++) {
            String testName = ("test" + String.valueOf(i));
            testPlayers.add(i,testName);
        }

        for (String testPlayer : testPlayers) {
            testCars.put(testPlayer, new CarImpl());
        }
        Map<String, Car> playedGrandprix = grandprix.playGrandprix(numberOfTestTry, testCars);


        //then

        //출력값 확인
        assertThat(outputStreamCaptor.toString().trim()).contains("실행 결과");
        for (String testPlayer : testPlayers) {
            assertThat(outputStreamCaptor.toString().trim()).contains(testPlayer + " : -");
        }

        //설정한 회수 만큼 실행 됐는지 확인
        assertThat(grandprix.getNumberOfTrials()).isEqualTo(numberOfTestTry);
        //설정한 인원수만큼 참가하였는지 확인
        assertThat(grandprix.getNumberOfCars()).isEqualTo(numberOfTestPlayer);

        //설정된 player 가 제대로 들어갔는지 확인
        assertThat(playedGrandprix.size()).isEqualTo(numberOfTestPlayer);
        for (String testPlayer : testPlayers) {
            assertThat(playedGrandprix.keySet().contains(testPlayer));
        }
    }
}