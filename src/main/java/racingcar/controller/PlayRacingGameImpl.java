package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RemainRacingCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class PlayRacingGameImpl implements PlayRacingGame{

    FindWinners findWinners=new FindWinnersImpl();
    PlayEachRacingGame playEachRacingGame=new PlayEachRacingGameImpl();
    ValidCars validCars=new ValidCarsImpl();
    ValidRacingCount validRacingCount=new ValidRacingCountImpl();
    OutputView outputView=new OutputView();

    InputView inputView=new InputView();

    public void playRacingGame() {
        List<Car> cars=validCars.getValidCars();

        RemainRacingCount remainRacingCount=validRacingCount.getValidRacingCount();
        outputView.printResult();
        while(remainRacingCount.isRemainRacingCount()){
            remainRacingCount.minusRemainRacingCount();
            cars=playEachRacingGame.getPlayEachRacingGame(cars);
        }
        List<String> winners=findWinners.getWinner(cars);
        outputView.printWinner(winners);

        inputView.close();

    }
}
