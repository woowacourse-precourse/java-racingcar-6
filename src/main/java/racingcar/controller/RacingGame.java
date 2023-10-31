package racingcar.controller;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.domain.CarList.getCarList;
import static racingcar.domain.TryNum.getTryNum;
import static racingcar.view.InputView.requestCarNamesText;
import static racingcar.view.InputView.requestTryNumText;
import static racingcar.view.OutputView.printGameResult;
import static racingcar.view.OutputView.printCarMovement;

public class RacingGame {
    public void RunGame(){
        requestCarNamesText();

        List<Car> carList = getCarList();

        requestTryNumText();

        int count = getTryNum();

        System.out.println();

        printGameResult();

        for(int i = 0; i < count; i++){
            carMovementOfGame(carList);
        }
    }

    private void carMovementOfGame(List<Car> carList){
        for (Car car : carList){
            car.carMovement();
            printCarMovement(car.getCarName(), car.getPosition());
        }
        System.out.println();
    }
}