package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.io.CommandLineReader;
import racingcar.io.CommandLineWriter;

import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = createRacingCarController();
        racingCarController.racingStart();
    }

    private static RacingCarController createRacingCarController() {
        CommandLineWriter commandLineWriter = new CommandLineWriter();
        CommandLineReader commandLineReader = new CommandLineReader();
        RacingCarView racingCarView = new RacingCarView(commandLineReader, commandLineWriter);
        return new RacingCarController(racingCarView);
    }
}
