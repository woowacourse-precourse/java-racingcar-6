package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TrialNumber;
import racingcar.service.GameService;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    Cars cars;
    TrialNumber trialNumber;
    GameService gameService = new GameService();

    /**
     * 자동차 이름을 입력 받기
     */
    private void getCarListByUserInput() {
        InputView.requestCarsName();
        String carsName = Console.readLine();
        cars = new Cars(Parser.parseCarsName(carsName));
    }

    /**
     * 시도 회수 입력 받기
     */
    private void getTrialNumberByUserInput() {
        InputView.requestTrialNumber();
        String inputNumber = Console.readLine();
        System.out.println();
        trialNumber = new TrialNumber(inputNumber);
    }

    /**
     * 입력 회수만큼 게임 진행
     */
    private void playGame() {
        OutputView.printResultHeader();
        int rounds = trialNumber.getTrialNumber();
        for (int count = 0; count < rounds; count++) {
            playSingleGame(cars.getCars());
        }
    }

    /**
     * 게임 1회 진행
     */
    private void playSingleGame(List<Car> cars) {
        cars.forEach(Car::move);
        OutputView.printResult(cars);
    }

    /**
     * 모든 게임 종료 시 우승 자동차 선정
     */
    private void endGame(List<Car> cars) {
        List<String> winnerName = gameService.getWinnerCars(cars);
        OutputView.printWinner(winnerName);
    }
}