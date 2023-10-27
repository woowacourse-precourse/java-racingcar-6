package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarValidation;
import racingcar.model.Constants;
import racingcar.model.Race;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class GameController {
    private Race race;
    private ConsoleOutputView consoleOutputView;

    public GameController(Race race, ConsoleOutputView consoleOutputView) {
        this.race = race;
        this.consoleOutputView = consoleOutputView;
    }

    public void runGame() {
        inputCarNames();                     // 설명과 함께 자동차 이름 입력
        int tryNumber = inputTryNumber();    // 설명과 함께 실행 횟수 입력
        System.out.println();

        /*
         * 횟수만큼 레이스 진행 및 최종 우승자 발표
         */
        consoleOutputView.showExecutionResultsHeader();
        for (int i = 0; i < tryNumber; i++) {
            race.runRace();
            consoleOutputView.showExecutionResults(race.getCarNames(), race.getCarGoingCount());
        }
        consoleOutputView.showWinner(race.getWinners());
    }

    private void inputCarNames() {
        consoleOutputView.showInputCarNamesPrompt();
        String inputList = ConsoleInputView.getUserInput();
        String[] inputArr = inputList.split(",");
        ArrayList<String> carNames = CarValidation.validateAll(inputArr);
        race.initialize(carNames);  // arraylist 에서 set 메서드로 접근하기 위해 실시하는 초기화 및 carNames 전달
    }

    private int inputTryNumber() {
        consoleOutputView.showInputTryNumberPrompt();
        String inputNumber = ConsoleInputView.getUserInput();
        int tryNumber = Integer.parseInt(inputNumber);
        if (tryNumber < Constants.MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("잘못된 시도 횟수입니다.");
        }
        return tryNumber;
    }
}
