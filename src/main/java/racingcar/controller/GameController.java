package racingcar.controller;

import java.util.List;
import racingcar.model.CarModel;
import racingcar.util.Util;

public class GameController {
    private final List<CarModel> carList;
    private final Util util;

    public GameController(List<CarModel> carList, Util util) {
        this.carList = carList;
        this.util = util;
    }

    public void race() {
        for (CarModel car : carList) {
            moveForwardOrNothing(car);
        }
    }

    private void moveForwardOrNothing(CarModel car) {
        int randomNumber = util.generateRandomNumber();

        if (util.isUpperThanCanForwardNumber(randomNumber)) {
            car.increaseForward();
        }
    }

    public void showCurrentResult() {
        for (CarModel car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void showWinnerCars() {
        List<CarModel> winnerList = util.calculateWinner(carList);
        String result = util.generateWinnerList(winnerList);

        System.out.println("최종 우승자 : " + result);
    }
}
