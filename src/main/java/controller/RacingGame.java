package controller;

import repository.CarListRepository;
import repository.GameStatus;
import service.CarListService;
import service.RaceWinnerDecider;
import service.Round;
import view.InputView;
import view.OutputView;

import java.util.stream.IntStream;

import static service.RandomMovementDecider.decideForwardMovement;

public class RacingGame {
    private final CarListService carList;
    public RacingGame() {
        this.carList = new CarListService();
    }

    public void gameSetting() {
        carList.init(InputView.setCarNames());
        Integer rounds = Round.setRound();

        RacingGame.playRound(rounds);
    }

    public void static void playRound(int rounds){
        IntStream.range(0, rounds)
                .forEach(round ->{
                    decideForwardMovement(carListRepository);
                    OutputView.displayRaceResult(carListRepository.carList);
                });
    }

}

//  for (int Try = 0; Try < tryNumber; Try++) {
//        decideForwardMovement(carListRepository);
//        if(Try == 0){
//        OutputView.displayPlayResult();
//        OutputView.displayRaceResult(carListRepository.carList);
//        } else {
//        OutputView.displayRaceResult(carListRepository.carList);
//        }
//        }
//        OutputView.displayWinners(RaceWinnerDecider.decideWinner(carListRepository.carList));
//
