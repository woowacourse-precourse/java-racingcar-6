package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.CarList.getCarList;
import static racingcar.domain.TryNum.getTryNum;
import static racingcar.view.InputView.requestCarNamesText;
import static racingcar.view.InputView.requestTryNumText;
import static racingcar.view.OutputView.*;

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

        printStringListJoinComma(getWinnerList(carList));
    }

    private void carMovementOfGame(List<Car> carList){
        for (Car car : carList){
            car.carMovement();
            printCarMovement(car.getCarName(), car.getPosition());
        }
        System.out.println();
    }

    private List<String> getWinnerList(List<Car> carList) {
        List<String> winner = new ArrayList<>();

        for (Car car : carList){
            if (car.getPosition() == getGreatPosition(carList)){
                winner.add(car.getCarName());
            }
        }

        return winner;
    }

    private int getGreatPosition(List<Car> carList) {
        int greatPosition = 0;

        for (Car car : carList){
            int position = car.getPosition();

            if (position >= greatPosition){
                greatPosition = position;
            }
        }

        return greatPosition;
    }
}