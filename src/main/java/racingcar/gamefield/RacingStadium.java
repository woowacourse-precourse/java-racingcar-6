package racingcar.gamefield;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.car.CarsStatusDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingStadium {

    private final InputView inputView;
    private final OutputView outputView;
    private final Racing racing;
    private final CarFactory carFactory;


    public RacingStadium() {
        inputView = new InputView();
        outputView = new OutputView();
        racing = new Racing();
        carFactory = new CarFactory();
    }

    public void run() {
        List<String> carNameList = inputView.requestCarNamesInput();
        List<Car> carList = carFactory.generateCarListWithName(carNameList);
        startRacing(carList);
        List<String> winnerList = racing.getWinnerList(carList);
        outputView.responseRaceWinner(winnerList);
    }

    private void startRacing(List<Car> carList) {
        int repeatTimes = inputView.requestRepeatTimesInput();
        outputView.responseRaceResultMessage();
        for (int i = 0; i < repeatTimes; i++) {
            tryEachCarGoForward(carList);
            CarsStatusDto carsStatus = racing.getCarsStatus(carList);
            outputView.responseCurrentCarsStatus(carsStatus);
        }
    }

    private void tryEachCarGoForward(List<Car> carList) {
        for (Car car : carList) {
            car.goForward();
        }
    }
}
