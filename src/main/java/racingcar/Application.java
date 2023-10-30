package racingcar;

import racingcar.controller.GameController;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.service.GameService;

public class Application {
    private static final String PRINT_EXIT_GAME = "게임 종료";

    public static void main(String[] args) {
        boolean progress = true;

        while(progress) {
            progress = createGameController().Progress();
        }
        System.out.println(PRINT_EXIT_GAME);
    }

    private static GameController createGameController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();
        Validator validator = new Validator();
        return new GameController(inputView, outputView, gameService, validator);
    }
}
