package controller;

import repository.CarListRepository;
import service.RaceWinnerDecider;
import view.InputView;
import view.OutputView;

import static service.RandomMovementDecider.decideForwardMovement;

public class RacingGame {
    public void gameStart() {
        CarListRepository carListRepository = new CarListRepository();
        carListRepository.setCarListRepository(InputView.setCarNames());

        int tryNumber = Integer.parseInt(InputView.setTryNumber());
        for (int Try = 0; Try < tryNumber; Try++) {
            decideForwardMovement(carListRepository);
            if(Try == 0){
                OutputView.displayPlayResult();
                OutputView.displayRaceResult(carListRepository.carList);
            } else {
                OutputView.displayRaceResult(carListRepository.carList);
            }
        }
        OutputView.displayWinners(RaceWinnerDecider.decideWinner(carListRepository.carList));
    }

}
