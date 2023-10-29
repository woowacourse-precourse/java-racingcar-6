package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RaceGameController {

    private List<Car> carList = new ArrayList<>();
    private List<String> winnerList = new ArrayList<>();
    private int attemptNumber;

    public void start() {

    }

    private void convertCarList(List<String> carInputList) {
        int i = 0;
        while (carInputList.size() > i) {
            Car newCar = new Car(carInputList.get(i));
            carList.add(newCar);
            i++;
        }
    }

    // 게임 1회 실행 및 결과 출력
    private void startOneRoundGame() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).oneGameStart();
            OutputView.printGameResult(carList.get(i));
            OutputView.printLine();
        }
        OutputView.printLine();
    }

    // 가장 많이 전진한 자동차 객체를 반환
    private Car getMaxForwardCountCar() {
        Car maxForwardCar = carList.stream()
                .max(Comparator.comparingInt(Car::getForwardCount))
                .get();
        return maxForwardCar;
    }

    // 최종 우승자를 선정
    private void setWinnerList(Car maxForwardCar) {
        for (Car car : carList) {
            if (car.getForwardCount() == maxForwardCar.getForwardCount()) {
                winnerList.add(car.getCarName());
            }
        }
    }

}
