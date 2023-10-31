package racingcar.ui.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.playrule.RandomNumberRacingRule;
import racingcar.properties.RacingProperty;
import racingcar.racing.RacingManager;
import racingcar.racingcar.Car;
import racingcar.racingcar.RacingParticipants;

class ResultViewerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    ResultViewer resultViewer;
    RacingManager racingManager;

    @BeforeEach
    void init() {
        racingManager = new RacingManager(
                new RacingProperty(
                        new RacingParticipants(List.of("a", "b", "c")),
                        "5",
                        new RandomNumberRacingRule()
                )
        );

        resultViewer = new ResultViewer(racingManager);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    void printCurrentPositions() {
        resultViewer.printCurrentPositions();

        assertThat(outContent.toString()).contains("a :");
        assertThat(outContent.toString()).contains("b :");
        assertThat(outContent.toString()).contains("c :");
    }

    @Test
    void printWinner() {
        resultViewer.printWinner();

        assertThat(outContent.toString()).contains("최종 우승자 :");
    }
}