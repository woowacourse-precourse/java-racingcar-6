package racingcar.domain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 게임_결과() {
        List<Car> winners = new ArrayList<>();
        winners.add(Car.registerCar("pobi"));
        winners.add(Car.registerCar("domo"));
        GameResult gameResult = GameResult.from(winners);
        gameResult.gameResultPrint();
        Assertions.assertEquals("최종 우승자 : pobi, domo", outContent.toString().trim());
    }
}