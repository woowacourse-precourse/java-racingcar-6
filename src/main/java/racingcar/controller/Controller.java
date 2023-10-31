package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Cars;
import racingcar.model.TrialNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    Cars cars;
    TrialNumber trialNumber;

    //게임 실행
    public void run() {
        requestCarNames(); //자동차 입력
        requestTrialNumber(); //회수 입력
        playGame(); //게임 시작
        endGame(); //우승자 출력
    }

    // 자동차 이름을 입력 받기
    private void requestCarNames() {
        InputView.requestCarNames();
        String carNames = Console.readLine();
        cars = new Cars(carNames);
    }

    // 시도 회수 입력 받기
    private void requestTrialNumber() {
        InputView.requestTrialNumber();
        String inputNumber = Console.readLine();
        System.out.println();
        trialNumber = new TrialNumber(inputNumber);
    }

    // 입력 회수만큼 게임 진행
    private void playGame() {
        OutputView.printResultHeader();
        int rounds = trialNumber.getTrialNumber();
        for (int i = 0; i < rounds; i++) {
            playSingleGame();
        }
    }

    // 1회 게임 진행
    private void playSingleGame() {
        cars.moveCars();
        OutputView.printResult(cars.getCars());
    }

    // 모든 게임 종료 시 우승 자동차 선정
    private void endGame() {
        List<String> winnerName = cars.getWinnerCars();
        OutputView.printWinner(winnerName);
    }
}