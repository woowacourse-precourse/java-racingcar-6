package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Dice;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        Dice dice = Dice.getInstance();
        List<Car> carList = getCarList(inputView.inputNames());
        int tryNumber = inputView.inputTryNumber();

        for(int i=0; i<tryNumber; i++){
            moveOrStay(carList, dice);
            outputView.printResult(carList);
        }
        outputView.printWinner(carList);

    }

    public List<Car> getCarList(List<String> nameList){
        return nameList.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    public void moveOrStay(List<Car> carList, Dice dice){
        carList.stream()
                .forEach(car -> car.move(dice.getRandomNumber()));
    }
}


