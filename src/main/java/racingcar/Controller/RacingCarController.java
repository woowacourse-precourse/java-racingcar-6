package racingcar.Controller;

import racingcar.Service.RandomAdvanceOrstop;
import racingcar.Service.UserInput;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.View.PrintScoreMessage;

public class RacingCarController {
    InputView inputView;
    UserInput userInput = new UserInput();
    RandomAdvanceOrstop randomAdvanceOrstop = new RandomAdvanceOrstop();
    OutputView outputView = new OutputView();

    public void run() throws IllegalAccessException {
        startCar(); //입력
        executionResult();   //결과
        winnerResult(); //최종 우승자 결과
    }

    private void startCar() throws IllegalAccessException { //글자수 5이하 조건 아닐 시 예외처리
        InputView.printInputCarName();  //"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"
        userInput.userInputCarName();
        InputView.printTryNumber(); //"시도할 횟수는 몇 회인가요?"
        userInput.tryNumber();
    }
    private void executionResult() {    //실행결과
        randomAdvanceOrstop.judgeAdvanceOrStop();
    }

    private void winnerResult() {   //최종 우승자 결과
        outputView.printWinnerResult();
    }

}
