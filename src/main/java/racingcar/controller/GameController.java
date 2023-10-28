package racingcar.controller;

import racingcar.model.Input;
import racingcar.model.Race;
import racingcar.view.ConsoleOutputView;

public class GameController {
    private final Race race;
    private final Input input;

    public GameController(Race race, Input input) {
        this.race = race;
        this.input = input;
    }

    public void runGame() {
        System.out.println(ConsoleOutputView.showInputCarNamesPrompt());
        input.inputCarNames(race);               // 자동차 이름 입력
        System.out.println(ConsoleOutputView.showInputTryNumberPrompt());
        int tryNumber = input.inputTryNumber();  // 실행 횟수 입력
        System.out.println();

        /*
         * 횟수만큼 레이스 진행 및 최종 우승자 발표
         */
        System.out.println(ConsoleOutputView.showExecutionResultsHeader());
        for (int i = 0; i < tryNumber; i++) {
            race.runRace();
            System.out.println(ConsoleOutputView.showExecutionResults(race.getCarNames(), race.getCarGoingCount()));
        }
        System.out.println(ConsoleOutputView.showWinner(race.winners()));
    }
}
