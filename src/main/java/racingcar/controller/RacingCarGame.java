package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Dice;
import racingcar.service.RacingCarGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final InputView inputView;
    private final RacingCarGameService racingCarGameService;
    private final OutputView outputView;

    public RacingCarGame() {
        this.inputView = new InputView();
        this.racingCarGameService = new RacingCarGameService();
        this.outputView = new OutputView();
    }

    public void run(){
        List<Car> carList = getCarList(inputView.inputNames());
        int tryNumber = inputView.inputTryNumber();

        for(int i=0; i<tryNumber; i++){
            moveOrStop(carList);
            System.out.println();
            outputView.printResult(carList);
        }

        outputView.printWinner(carList);

    }

    public List<Car> getCarList(List<String> nameList){
        return nameList.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }

    public void moveOrStop(List<Car> carList){
        carList.stream()
                .forEach(car -> racingCarGameService.moveOrStop(Dice.getRandomNumber(), car));
    }
}


