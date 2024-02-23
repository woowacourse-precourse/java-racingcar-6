package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Service.JudgeWinnerResult;
import racingcar.Service.UserInputTryNumber;
import racingcar.Util.RandomAdvanceOrStop;
import racingcar.Service.UserInputCarName;
import racingcar.View.OutputView;

public class RacingCarController {
    Car cars = new Car();
    UserInputCarName userInputCarName = new UserInputCarName();
    UserInputTryNumber userInputTryNumber = new UserInputTryNumber();
    OutputView outputView = new OutputView();
    JudgeWinnerResult judgeWinnerResult = new JudgeWinnerResult();
    RandomAdvanceOrStop randomAdvanceOrstop = new RandomAdvanceOrStop();

    public void run() throws IllegalAccessException {
        startCar(); //입력
        executionResult();   //실행결과
        winnerResult(); //최종 우승자 결과
    }

    private void startCar() throws IllegalAccessException {
        userInputCarName.userInputCarName();
        userInputTryNumber.userInputTryNumber();
    }
    private void executionResult() throws IllegalAccessException {    //실행결과
        randomAdvanceOrstop.judgeAdvanceOrStop();
    }

    public void winnerResult() throws IllegalAccessException {   //최종 우승자 결과
        outputView.printWinnerResult();
        judgeWinnerResult.judgeWinner();
    }
}
