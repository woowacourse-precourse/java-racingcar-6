package racingcar.controller;


import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.utils.InputValidator;
import racingcar.utils.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingCarService racingGameService;

    public RacingGameController() {
        this.racingGameService = new RacingCarService();
    }

    public void playRacingGame() {
        String input = InputView.inputCarsName();
        List<String> cars = Arrays.asList(input.split(","));
        List<Car> carList = racingGameService.participateCar(cars);

        String moveCountStr = InputView.inputMovesCount();
        InputValidator.validateEmptyInput(moveCountStr);
        int moveCount = InputValidator.validateNonNumeric(moveCountStr);
        
        System.out.println(Message.EXECUTION_RESULT_MESSAGE.getMessage());
        while (moveCount-- > 0) {
            RacingCarService.moveCar();
            System.out.println();
        }
        OutputView.printFinalWinner(racingGameService.findWinners());
    }
}
