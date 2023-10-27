package racingcar.controller;

import racingcar.model.Input;
import racingcar.model.Race;
import racingcar.view.ConsoleOutputView;

public class GameController {
    private Race race;
    private ConsoleOutputView consoleOutputView;

    public GameController(Race race, ConsoleOutputView consoleOutputView) {
        this.race = race;
        this.consoleOutputView = consoleOutputView;
    }

    public void runGame() {
        System.out.println(consoleOutputView.showInputCarNamesPrompt());
        Input.inputCarNames(race);               // 자동차 이름 입력
        System.out.println(consoleOutputView.showInputTryNumberPrompt());
        int tryNumber = Input.inputTryNumber(); // 실행 횟수 입력
        System.out.println();

        /*
         * 횟수만큼 레이스 진행 및 최종 우승자 발표
         */
        System.out.println(consoleOutputView.showExecutionResultsHeader());
        for (int i = 0; i < tryNumber; i++) {
            race.runRace();
            System.out.println(consoleOutputView.showExecutionResults(race.getCarNames(), race.getCarGoingCount()));
        }
        System.out.println(consoleOutputView.showWinner(race.getWinners()));
    }
}
