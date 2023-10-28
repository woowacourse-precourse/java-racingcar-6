package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.TrialNumber;
import racingcar.utils.Parser;
import racingcar.view.InputView;

public class Controller {
    Cars cars;
    TrialNumber trialNumber;

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
}