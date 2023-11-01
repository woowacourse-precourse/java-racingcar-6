package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.constant.ProductConstant.*;

public class RacingCarController {
    public int start = 0;
    public String input = null;
    public RacingCarService racingCarService = new RacingCarService();
    public InputView inputView = new InputView();
    public OutputView outputView = new OutputView();

    public void playGame() {

        System.out.println(INPUT_NAMES);

        input = inputView.inputCarNames();
        List<RacingCar> racingCars = racingCarService.initRacingCarMembers(input);

        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);

        input = inputView.inputNumberOfAttempts();
        int attempts = racingCarService.initNumberOfAttempts(input);

        System.out.println("\n" + GAME_RESULT);

        while (start < attempts) {
            racingCars = racingCarService.movingForward(racingCars);
            outputView.getRaceResult(racingCars);

            start = racingCarService.addTime(start);
        }

        List<String> finalWinner = racingCarService.getFinalWinner(racingCars);
        outputView.printWinners(finalWinner);
    }
}
