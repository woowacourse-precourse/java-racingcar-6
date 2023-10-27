package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;
import racingcar.view.ConsoleOutputView;

class GameControllerTest {
    private GameController gameController;
    private Race race;
    private ConsoleOutputView consoleOutputView;

    @BeforeEach
    void setUp() {
        race = mock(Race.class);
        consoleOutputView = mock(ConsoleOutputView.class);
        gameController = new GameController(race, consoleOutputView);
    }

    @Test
    void runGame_() {

    }
}