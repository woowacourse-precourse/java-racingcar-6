package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.io.CommandLineReader;
import racingcar.io.CommandLineWriter;

import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = createRacingCarController();
        racingGameController.startRacing();
    }

    private static RacingGameController createRacingCarController() {
        CommandLineWriter commandLineWriter = new CommandLineWriter();
        CommandLineReader commandLineReader = new CommandLineReader();
        RacingGameView racingGameView = new RacingGameView(commandLineReader, commandLineWriter);
        return new RacingGameController(racingGameView);
    }
}
