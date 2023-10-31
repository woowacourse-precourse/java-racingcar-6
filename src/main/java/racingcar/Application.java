package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.handler.InputConvertor;
import racingcar.handler.InputHandler;
import racingcar.handler.InputValidator;
import racingcar.service.RacingCarService;
import racingcar.service.random.DefaultRandomNumberProvider;
import racingcar.view.OutputView;
import racingcar.view.input.ConsoleInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var inputHandler = new InputHandler(new InputConvertor(), new InputValidator(),
            new ConsoleInputView());

        var racingCarController = new RacingCarController(inputHandler, new OutputView(),
            new RacingCarService(new DefaultRandomNumberProvider()));

        racingCarController.run();
    }
}
