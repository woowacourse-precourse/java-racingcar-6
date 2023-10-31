package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void setForwardStep_랜덤값에_따라_전진값으로_1또는0_반환() {
        int forwardStep = Application.setForwardStep();
        assertThat(forwardStep == 0 || forwardStep == 1);
    }

    @Test
    void findWinnerForward_우승_기준_전진값을_찾아_반환() {
        Car[] cars = new Car[]{
                new Car("gamza"), new Car("toni"), new Car("sam")
        };
        cars[0].forward(0);
        cars[1].forward(1);
        cars[2].forward(2);

        int winnerForward = Application.findWinnerForward(cars);
        assertThat(winnerForward).isEqualTo(2);
    }

    @Test
    void makeWinnerList_우승_자동차_리스트_반환_단수() {
        Car[] cars = new Car[]{
                new Car("gamza"), new Car("toni"), new Car("sam")
        };
        cars[0].forward(0);
        cars[1].forward(1);
        cars[2].forward(2);

        List<String> answer = new ArrayList<>();
        answer.add("sam");

        List<String> winners = Application.makeWinnerList(cars);
        assertThat(winners).isEqualTo(answer);
    }

    @Test
    void makeWinnerList_우승_자동차_리스트_반환_다수() {
        Car[] cars = new Car[]{
                new Car("gamza"), new Car("toni"), new Car("sam")
        };

        cars[0].forward(0);
        cars[1].forward(2);
        cars[2].forward(2);

        List<String> answer = new ArrayList<>();
        answer.add("toni");
        answer.add("sam");

        List<String> winners = Application.makeWinnerList(cars);
        assertThat(winners).isEqualTo(answer);
    }

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void printWinner_우승_자동차_출력() {
        List<String> winners = new ArrayList<>();
        winners.add("gamza");
        winners.add("tom");
        winners.add("sally");
        String answer = "gamza, tom, sally";

        Application.printWinner(winners);

        assertThat(output.toString().trim()).isEqualTo(answer);

    }

}
