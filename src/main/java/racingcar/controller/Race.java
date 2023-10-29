package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private int moveCnt;
    public void run() {
        OutputView.printRacingStart();
        callCarNames();
        OutputView.printAskCount();
        moveCnt = getMoveCount();
        OutputView.printResult();
        while(moveCnt > 0){
            for (Car car : cars) {
                car.move();
                OutputView.printCarsMove(car.getName(), car.getPosition());
            }
            System.out.println();
            moveCnt--;
        }

        int currentMaxPostion = 0;
        for (Car car : cars) {
            currentMaxPostion = Math.max(currentMaxPostion,car.getPosition());
        }

        List<Car> currentWinner = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == currentMaxPostion){
                currentWinner.add(car);
            }
        }

        StringBuilder winnerResult = new StringBuilder();
        for (int i = 0; i < currentWinner.size(); i++) {
            winnerResult.append(currentWinner.get(i));
            if(i != currentWinner.size()-1){
                winnerResult.append(",");
            }
        }
        OutputView.printWinner(winnerResult.toString());

    }

    private static int getMoveCount() {
        String userInput = InputView.userInput();
        return Integer.parseInt(userInput);
    }


    private void callCarNames() {
        String input = InputView.userInput();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }



}

