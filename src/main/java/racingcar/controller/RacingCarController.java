package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarData;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    public static void startRacingCar() {
        OutputView.carNameInput();
        List<String> participantList = InputView.carName();
        OutputView.attemptCountInput();
        int attempt = InputView.attempt();
        OutputView.executionResultView();
        List<RacingCar> carList = RacingCarData.carData(participantList);
        do {
            playRacingCar(carList);
            attempt--;
        } while (attempt != 0);
        winnerResult(carList);
    }

    public static void playRacingCar(List<RacingCar> carList) {
        RacingCarData.RacingCarResult(carList);
    }

    public static void winnerResult(List<RacingCar> carList) {
        OutputView.finalWinnerView();
        OutputView.colon();
        System.out.println(Winner.winnerList(carList));
    }

}
