package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    Validator validator = new Validator();

    public void gameStart(){
        RacingGame racingGame = initRacingGame();
        play(racingGame);
    }

    private RacingGame initRacingGame(){
        return new RacingGame(initCars(getCarNames()), getTryCount());
    }

    private List<Car> initCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames){
            cars.add(new Car(carName));
        }

        return cars;
    }

    private List<String> getCarNames(){
        String input = InputView.carNames();
        validator.carNamesInput(input);
        return Parser.carNames(input);
    }

    private int getTryCount(){
        String input = InputView.tryCount();
        validator.tryCountInput(input);
        return Parser.tryCount(input);
    }

    private void play(RacingGame racingGame){
        OutputView.printTitle();
        while(!racingGame.checkGameFinished()){
            racingGame.racingOnce();
            racingGame.increaseTryNum();
            OutputView.printScore(racingGame);
        }
        OutputView.printWinners(racingGame.getWinners());
    }

}
