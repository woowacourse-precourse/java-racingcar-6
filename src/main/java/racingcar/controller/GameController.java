package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void carRacing(){
        List<Car> cars = newCars();
        int RoundCount = inputView.inputCount();
        for (int i=0; i< RoundCount; i++){
            roundCar(cars);
            outputView.displayResults(cars);
            System.out.println();
        }
        OutputView.displayWinner(cars);
    }



    private List<Car> newCars(){
        String[] carNames=inputView.inputCarNames();
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    public static void roundCar(List<Car> cars){
        for(Car car : cars){
            car.updatePosition();
        }
    }
}
