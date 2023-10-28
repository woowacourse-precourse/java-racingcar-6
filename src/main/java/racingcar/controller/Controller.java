package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.utils.Parser;
import racingcar.view.InputView;

public class Controller {
    Cars cars;

    /**
     * 자동차 이름을 입력 받기
     */
    private void getCarListByUserInput() {
        InputView.requestCarsName();
        String carsName = Console.readLine();
        cars = new Cars(Parser.parseCarsName(carsName));
    }
}