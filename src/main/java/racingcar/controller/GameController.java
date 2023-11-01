package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.utils.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final RacingController racingController = new RacingController();
    private final InputException inputException = new InputException();
    private final Parser parser = new Parser();

    public void run() {
        List<Car> carList = racingCarList();
        int trialNum = setTrialNum();
        Game game = new Game(carList, trialNum);

        while(!finishGame(trialNum,game.getTriedNum())){
            racingController.play(game);
            OutputView.printScore(game.getCars());
        }

        List<String> winner = racingController.getWinner(game);
        OutputView.printWinner(winner);
    }

    private List<Car> racingCarList(){
        String participatingCar = InputView.requestCarName();
        List<String> participatingCars = parser.parseCar(participatingCar);
        inputException.checkCarNames(participatingCars);
        return racingCars(participatingCars);
    }

    private List<Car> racingCars(List<String> participatingCars){
        List<Car> racingCars = new ArrayList<>();
        for (String participatingCar : participatingCars){
            Car racingCar = new Car(participatingCar);
            racingCars.add(racingCar);
        }
        return racingCars;
    }

    private int setTrialNum(){
        String trial = InputView.requestNumberOfTry();
        inputException.checkNumberOfTry(trial);
        return parser.parseNumberOfTry(trial);
    }

    private boolean finishGame(int trialNum, int triedNum){
        if (trialNum == triedNum){
            return false;
        }
        return true;
    }
}
