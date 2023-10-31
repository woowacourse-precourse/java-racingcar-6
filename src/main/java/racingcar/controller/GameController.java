package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final GameService service = new GameService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void playGame(){
        List<String> carNames = inputView.startGame();
        Integer tryCount = inputView.inputTryCount();
        List<Car> cars = service.makeCars(carNames);

        for(int i=0; i<tryCount; i++){
            forwardCars(cars);
            System.out.println();
        }
        List<String> winnerNames = service.findEqualsMaxPlace(cars);
        outputView.printWinner(winnerNames);
    }
    private void forwardCars(List<Car> cars){
        for(Car car: cars){
            car.forward();
            outputView.printEachFoward(car.getName(), car.getPlace());
        }
    }
}
