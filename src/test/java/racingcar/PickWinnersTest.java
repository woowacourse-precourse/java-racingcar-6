package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PickWinnersTest {
    private final ByteArrayOutputStream outputStreamForTest = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStream() {
        String mockInput = "alpha,bravo,charm\n5";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        System.setOut(new PrintStream(outputStreamForTest));
    }

    @AfterEach
    public void restoreStreams() {
        Console.close();
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void pickWinners() {
        Cars cars = new Cars();
        RaceLap raceLap = new RaceLap();
        PaceComputer paceComputer = new PaceComputer(true,7);
        LeaderBoard leaderBoard = new LeaderBoard();

        cars.getInput();
        raceLap.getInput();

        leaderBoard.showRace(cars, raceLap, paceComputer);

        assertThat(outputStreamForTest.toString().contains("최종 우승자 : alpha, bravo, charm")).isTrue();
    }
}