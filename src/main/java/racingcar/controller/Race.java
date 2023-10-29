package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private final ArrayList<Car> carList = new ArrayList<>();
    private Cars cars;

    private int moveCnt;
    public void run() {
        OutputView.printRacingStart();
        callCarNames();
        OutputView.printAskCount();
        moveCnt = getMoveCount();
        OutputView.printResult();
        while(moveCnt > 0){
            cars.playSingleTurn();
            Map<String,Integer> currentPostion = cars.carsInformation();
            for (Entry<String, Integer> carsInformation : currentPostion.entrySet()) {
                OutputView.printCarsMove(carsInformation.getKey(),carsInformation.getValue());
            }
            System.out.println();
            moveCnt--;
        }

        int currentMaxPostion = 0;
        for (Car car : carList) {
            currentMaxPostion = Math.max(currentMaxPostion,car.getPosition());
        }

        List<Car> currentWinner = new ArrayList<>();
        for (Car car : carList) {
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
            carList.add(car);
        }

        cars = new Cars(carList);
    }



}

