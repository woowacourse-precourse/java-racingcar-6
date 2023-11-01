package racingcar;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarGameService;
import racingcar.validation.CarNameValidation;
import racingcar.validation.RoundValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        CarNameValidation carNameValidation = new CarNameValidation();
        RoundValidation roundValidation = new RoundValidation();
        RacingCarGameService gameService = new RacingCarGameService();

        outputView.printInputRacingCarNameMessage();
        List<String> carsName = inputView.readRacingCarName(carNameValidation);

        outputView.printInputNumberOfRoundMessage();
        int numberOfRound = inputView.readNumberOfRound(roundValidation);

        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carsName) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.add(racingCar);
        }

        outputView.printExecutionResultMessage();
        gameService.startRacingCarGame(outputView, racingCars, numberOfRound);

    }
}
