package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarValidation;
import racingcar.model.NumberValidation;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void runGame() {
        InputView inputView = new InputView();
        String[] inputArr = inputView.inputCarNames();                        // 자동차 이름 입력

        CarValidation carValidation = new CarValidation();
        ArrayList<String> carNames = carValidation.carValidateAll(inputArr);  // 자동차 이름 검증

        String inputNumber = inputView.inputTryNumber();                      // 실행 횟수 입력
        NumberValidation numberValidation = new NumberValidation();
        int tryNumber = numberValidation.numbervalidateAll(inputNumber);      // 실행 횟수 검증
        System.out.println();

        Race race = new Race();
        race.initialize(carNames);

        OutputView outputView = new OutputView();
        System.out.println(outputView.showExecutionResultsHeader());
        for (int i = 0; i < tryNumber; i++) {
            race.runRace();
            System.out.println(outputView.showExecutionResults(race.getCarNames(), race.getCarGoingCount()));
        }
        System.out.println(outputView.showWinner(race.winners()));
    }

}