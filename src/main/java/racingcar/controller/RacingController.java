package racingcar.controller;

import racingcar.view.OutputView;
import racingcar.view.InputView;
import racingcar.util.CarListGenerator;
import racingcar.util.NumJudge;
import racingcar.model.Car;
import racingcar.model.Round;

import java.util.ArrayList;

public class RacingController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    CarListGenerator carListGenerator = new CarListGenerator();
    NumJudge numJudge = new NumJudge();

    ArrayList<Car> carList = new ArrayList<>();

    public ArrayList<String> start() {
        outputView.printStartMessage();
        ArrayList<String> carList = carListGenerator.generateCarList(); // 차 이름 생성 및 list 생성
        outputView.printRoundNumMessage();
        return carList;
    }
}
