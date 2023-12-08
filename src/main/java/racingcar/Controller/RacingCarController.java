package racingcar.Controller;

import racingcar.Model.Cars;
import racingcar.Service.JudgeWinnerResult;
import racingcar.Util.RandomAdvanceOrstop;
import racingcar.Service.UserInput;
import racingcar.View.OutputView;
import static racingcar.Model.PrintInputMessage.*;

public class RacingCarController {
    UserInput userInput = new UserInput();
    RandomAdvanceOrstop randomAdvanceOrstop = new RandomAdvanceOrstop();
    OutputView outputView = new OutputView();
    Cars cars = new Cars();
    JudgeWinnerResult judgeWinnerResult = new JudgeWinnerResult();

    public void run() throws IllegalAccessException {
        startCar(); //입력
        executionResult();   //실행결과
        winnerResult(); //최종 우승자 결과
    }

    private void startCar() throws IllegalAccessException { //글자수 5이하 조건 아닐 시 예외처리
        printInputCarName();  //"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"
        userInput.userInputCarName();
        printTryNumber(); //"시도할 횟수는 몇 회인가요?"
        userInput.tryNumber();
    }
    private void executionResult() throws IllegalAccessException {    //실행결과
        randomAdvanceOrstop.judgeAdvanceOrStop();
    }

    public void winnerResult() throws IllegalAccessException {   //최종 우승자 결과
        judgeWinnerResult.judgeWinner();
    }
}
