package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.CreateCharacterService;
import racingcar.service.CreateTryCountService;
import racingcar.service.RacingGameService;
import racingcar.validation.CarNameValidation;
import racingcar.validation.TryCountValidation;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // 객체 생성
        InputView inputView = createInputView();
        OutputView outputView = new OutputView();
        RacingGameController racingGameController = createRacingGameController(inputView, outputView);

        // 메서드 호출
        executeControllers(racingGameController);
    }

    private static InputView createInputView() {
        CarNameValidation carNameValidation = new CarNameValidation();
        TryCountValidation tryCountValidation = new TryCountValidation();
        return new InputView(carNameValidation, tryCountValidation);
    }

    private static RacingGameController createRacingGameController(InputView inputView, OutputView outputView) {
        CreateCharacterService createCharacterService = new CreateCharacterService(inputView, outputView);
        CreateTryCountService createTryCountService = new CreateTryCountService(inputView, outputView);
        RacingGameService racingGameService = new RacingGameService(inputView, outputView);
        return new RacingGameController(racingGameService, createCharacterService, createTryCountService);
    }

    private static void executeControllers(RacingGameController racingGameController) {
        racingGameController.GameStart();
    }
}
