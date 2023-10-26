package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Dice;
import racingcar.service.RacingCarGameService;
import racingcar.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final InputView inputView;
    private final RacingCarGameService racingCarGameService;

    public RacingCarGame() {
        this.inputView = new InputView();
        this.racingCarGameService = new RacingCarGameService();
    }

    public void run(){
        List<Car> carList = getCarList(inputView.inputNames());
        int tryNumber = inputView.inputTryNumber();
        moveOrStop(carList, Dice.getRandomNumber());
        
    }

    public List<Car> getCarList(List<String> nameList){
        return nameList.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    public void moveOrStop(List<Car> carList, int diceNumber){
        carList.stream()
                .forEach(car -> racingCarGameService.moveOrStop(diceNumber, car));
    }
}


