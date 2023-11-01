package racingcar.controller;

import racingcar.model.Round;
import racingcar.view.OutputView;
import racingcar.view.InputView;
import racingcar.util.CarListGenerator;
import racingcar.model.Car;
import racingcar.model.CarService;
import racingcar.util.RaceNumGenerator;

import java.util.ArrayList;

public class RacingController {
    CarListGenerator carListGenerator = new CarListGenerator();
    ArrayList<Car> carsList = new ArrayList<>();
    InputView inputView = new InputView();
    Round round = new Round();
    CarService carService = new CarService();

    public void game() {
        OutputView.printStartMessage();
        carsList = carListGenerator.generateCarsList(carListGenerator.generateCarNameList()); //차 이름 입력받고 Car들이 들어있는 ArrayList 생ㅇ성
        OutputView.printRoundNumMessage();
        int inputRound = inputView.readRoundNum();
        OutputView.printResultStartMessage();
        while(round.getRoundNum()!=inputRound) {
            runRound();
            round.increaseRoundNum();
        }
        endGame();
    }

    public void runRound() {
        for (Car car : carsList) {
            if(RaceNumGenerator.generateNumber()>=4) {
                car.increaseCarLocation();
            }
            OutputView.printPlayerRoundResult(car.getName(),car.getLocation());
        }
        System.out.println(" ");
    }

    public void endGame() {
        ArrayList<String> winnerNameList = carService.decideWinner(carsList);
        OutputView.printWinnerResult(winnerNameList);
    }
}
