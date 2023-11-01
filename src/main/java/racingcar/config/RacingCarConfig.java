package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.CarService;
import racingcar.view.InputReader;
import racingcar.view.MessagePrinter;
import racingcar.view.RacingCarView;

public class RacingCarConfig {

    private RacingCarConfig(){ }

    public static RacingCarController getRacingCarController(){
        InputReader inputReader = new InputReader();
        MessagePrinter messagePrinter = new MessagePrinter();
        RacingCarView racingCarView = new RacingCarView(inputReader, messagePrinter);
        CarService carService = new CarService();
        return new RacingCarController(racingCarView, carService);
    }
}
