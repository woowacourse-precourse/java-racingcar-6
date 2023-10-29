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

    public void runOneRound(ArrayList<StringBuilder> carStringBuilders){
        int carIdx = 0;
        for (Car car : carList) {
            String carName = car.getName();
            Integer carLocation = car.getLocation();
            if(numJudge.judgeNum()){
                car.increaseCarLocation();
                outputView.appendStringBuilder(carIdx,carName,carStringBuilders);
            }
            outputView.printRoundResult(carIdx,carStringBuilders);
            carIdx ++;
        }
    }

    public ArrayList<Car> decideWinner(ArrayList<Car> carList) {
        ArrayList<Car> largestCars = new ArrayList<>();
        int maxValue = 0;
        for (Car car : carList) {
            maxValue = Math.max(car.getLocation(),maxValue);
        }
        for (Car car : carList) {
            if (car.getLocation() == maxValue) {
                largestCars.add(car);
            }
        }
        return largestCars;
    }

    public void endGame() {
        ArrayList<Car> largestCars = decideWinner(carList);
        outputView.printWinnerMessage();
        for (int i = 0; i < largestCars.size(); i++) {
            String carName = largestCars.get(i).getName();
            if (i == largestCars.size() - 1) {
                outputView.printLastWinnerResult(carName);
                break;
            }
            outputView.printWinnerResult(carName);
        }
    }

    public void game() {
        ArrayList<String> carNameList = start();
        int totalRoundNum = inputView.readRoundNum();

        Round round = new Round();

        for (String carName : carNameList) {
            Car car = new Car(carName,0);
            carList.add(car);
        }
        int numberOfCars = carList.size();

        ArrayList<StringBuilder> carStringBuilders = outputView.makeStringBuilders(numberOfCars);
        for(int i=0; i<carList.size(); i++) {
            Car nowCar = carList.get(i);
            outputView.appendDefaultString(i, nowCar.getName(), carStringBuilders);
        }
        while (round.getRoundNum() <= totalRoundNum) {
            runOneRound(carStringBuilders);
            round.increaseRoundNum();
            System.out.println(" ");
        }
        endGame();
    }
}
