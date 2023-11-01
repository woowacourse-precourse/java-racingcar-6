package racingcar.controller;

import static racingcar.service.GameService.determineWinner;
import static racingcar.service.GameService.game;
import static racingcar.service.InputService.setInputMessage;
import static racingcar.service.OutputService.gameResultMessage;
import static racingcar.service.OutputService.setOutputMessage;

public class GameController {
    public void start() {
        setInputMessage();
        setOutputMessage();
        game();
        gameResultMessage(determineWinner());
    }
}
