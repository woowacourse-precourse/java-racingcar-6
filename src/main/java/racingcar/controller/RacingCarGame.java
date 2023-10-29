package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private OutputView outputView = OutputView.getInstance();
    private InputView inputView = InputView.getInstance();
    private Cars cars = new Cars();

    public void run(){
        carInitialize();
        playRacingGame(inputView.InputTryNumber());

    }

    public void playRacingGame(int tryNumber) {
        outputView.printPlayResultMessage();
        for(int tryCount = 0; tryCount < tryNumber;tryCount++){
            pickEachCarRandomNumber(cars.getCars());
            printEachRoundResult(cars.getCars());
        }
    }

    public void printEachRoundResult(Map<String, Car> cars) {
        for (Car car : cars.values()) {
            outputView.printCarName(car);
            outputView.printCurrentCarPosition(car);
        }
        System.out.println();
    }


    public void pickEachCarRandomNumber(Map<String, Car> carsMap) {
        for (Car car : carsMap.values()) {
            int randomNumber = pickRandomNumber();
            judgeAdvanceOrLeft(car, randomNumber);
        }
    }

    public void judgeAdvanceOrLeft(Car car, int randomNumber) {
        if(randomNumber >= 4){
            int currentAdvanceCount = car.getAdvanceCount();
            car.setAdvanceCount(currentAdvanceCount + 1);
        }
    }

    public int pickRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void carInitialize() {
        String carNames = inputView.InputCarNames();
        List<String> carNameList = carList(carNames);
        cars.makeCarsFromCarList(carNameList);
    }

    public List<String> carList(String carNames){
        String[] carNameList = carNames.split("");
        return List.of(carNameList);
    }
}
