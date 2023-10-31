package racingcar.controller;

import racingcar.domain.CarRacing;
import racingcar.domain.CarRacingImp;
import racingcar.view.InputView;
import racingcar.view.OutView;

public class RacingCarController {
    public static void run() {
        CarRacing carRacing = new CarRacingImp();

        // 1. 자동차 이름 입력 받기
        OutView.printCarNames();
        carRacing.addCar(InputView.promptForCarNames());

        // 2. 경기 횟수 입력 받기
        OutView.printNumberOfAttempts();
        carRacing.addNumberOfRace(InputView.promptNumberOfAttempts());

        // 3. 자동차 레이싱 시작
        OutView.printResults();
        OutView.printRaceResults(carRacing.start());

        // 4. 우승자 출력
        OutView.printFinalWinner(carRacing.getWinner());

    }

}
