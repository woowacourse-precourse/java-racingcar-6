package racingcar.controller;


import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarController {
    private Cars cars;
    private TryCount tryCount;

    public void run() {
        Output.inputCarName();
        cars = new Cars(Input.getCarName());

        Output.printNumber_of_attempts();
        tryCount = new TryCount(Input.getNumber_of_attemps());

        race();

        theEnd();
    }

    private void race() {

        Output.printExecutionResult();

        int nowTrialCnt = 0;
        while(!tryCount.isSame(nowTrialCnt++)){
            cars.moveByRandomNumber();
            Output.printCarScore(cars.getCars());
        }
    }



    private void theEnd() {
        Output.printWinner(cars.getWinners());
    }
}
