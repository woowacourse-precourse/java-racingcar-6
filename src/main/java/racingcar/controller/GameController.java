package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    GameService service = new GameService();
    private final Integer tryCount;
    private final List<Car> cars;
    public GameController(){
        InputView inputView = new InputView();

        List<String> carNames = inputView.startGame();

        tryCount = inputView.inputTryCount();
        cars = service.makeCars(carNames);
    }
    public void game(){
        OutputView outputView = new OutputView();

        for(int i=0; i<tryCount; i++){
            for(Car car: cars){
                car.forward();
                outputView.printEachFoward(car.getName(), car.getPlace());
            }
            System.out.println();
        }
        List<String> winnerNames = service.findEqualsMaxPlace(cars);
        outputView.printWinner(winnerNames);
    }
}
