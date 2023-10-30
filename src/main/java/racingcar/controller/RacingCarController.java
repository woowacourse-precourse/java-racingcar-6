package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.User;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Car car;
    private final User user;
    private final Map<String,Integer> carMap;

    public RacingCarController() {
        outputView.start();
        this.car = new Car(inputView.createCar());
        outputView.moveSize();
        this.user = new User(inputView.moveSize());
        this.carMap = car.getCarMap();
    }
    private void move() {
        for (String car : carMap.keySet()) {
            if(user.moveForward()){
                carMap.put(car,carMap.getOrDefault(car,0)+1);
            }
        }
    }
    private List<String> winner() {
        List<String> winnerList = new ArrayList<>();
        int maxResult = Integer.MIN_VALUE;
        for (String car : carMap.keySet()) {
            if(carMap.get(car) > maxResult){
                winnerList.clear();
                maxResult = Math.max(maxResult,carMap.get(car));
            }
            if(isCoincide(maxResult,carMap.get(car)))
                winnerList.add(car);
        }
        return winnerList;
    }
    private boolean isCoincide(int maxResult, int currentNumber){
        return maxResult == currentNumber;
    }
    public void run() {
        List<String> carList = car.getCarList();
        StringBuilder sb;
        outputView.result();
        int moveSize = user.getMoveSize();
        while(moveSize--> 0) {
            sb = new StringBuilder();
            move();
            outputView.moveResult(carMap, carList,sb);
            outputView.printBuilder(sb);
        }
        outputView.winner();
        sb = new StringBuilder();
        outputView.winnerList(winner(),sb);
        outputView.printBuilder(sb);
    }
}
