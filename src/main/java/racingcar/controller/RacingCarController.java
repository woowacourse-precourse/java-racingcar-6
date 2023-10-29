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

        cars = new Cars(Input.getCarName()); // pobi,woni,jun

        Output.printNumber_of_attempts(); // 시도할 횟수는 몇회?
        tryCount = new TryCount(Input.getNumber_of_attemps());

        //경주 실행
        race();

        //경주 끝 최종 우승자
        theEnd();
    }

    private void race() {

        Output.printExecutionResult(); // 실행 결과

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
