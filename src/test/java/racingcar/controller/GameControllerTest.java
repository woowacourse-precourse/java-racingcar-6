package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import racingcar.model.Race;
import racingcar.view.ConsoleOutputView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameControllerTest {
    private GameController gameController;
    private Race race;
    private ConsoleOutputView consoleOutputView;
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        race = new Race();
        consoleOutputView = new ConsoleOutputView();
        gameController = new GameController(race, consoleOutputView);
    }

    @Test
    void runGame_ValidInput() {
        String input = "Car1,Car2,Car3\n3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        gameController.runGame();

        // 예상된 결과를 출력으로 가져와서 확인
        String expectedOutput = "자동차 대수는 몇 대 인가요?\n" +
                "시도할 회수는 몇 회 인가요?\n" +
                "\n" +
                "실행 결과\n" +
                "Car1 : -\n" +
                "Car2 : -\n" +
                "Car3 : -\n" +
                "\n" +
                "Car1, Car2, Car3가 경주를 완료했습니다.\n";
        assertEquals(expectedOutput, outputContent.toString());
    }

    @Test
    void runGame_InvalidTryNumber() {
        String input = "Car1,Car2,Car3\n-1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gameController.runGame();
        });

        assertEquals("잘못된 시도 횟수입니다.", exception.getMessage());
    }
}
