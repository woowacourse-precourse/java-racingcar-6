package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Racing racing = new Racing();
    CarList carList = new CarList();


    public void racingGame() {
        List<String> carNames = inputView.askName();
        List<Car> cars = carList.makeCarList(carNames, carNames.size());
        int count = inputView.askGameCount();
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            racing.startRacing(cars);
            outputView.showRacing(cars);
            System.out.println("");
        }
        System.out.println("최종 우승자 : " + outputView.selectWinner(cars));


    }

}