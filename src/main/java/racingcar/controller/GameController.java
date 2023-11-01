package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {
    private final Input input = new Input();
    private final Output output = new Output();
    private final GameService gameService = new GameService();

    public void run() {
        output.printInputCarName();
        List<Car> carList = createCarList();
        output.printInputRandomNumber();
        int roundNum = input.inputRoundNumber();
        Game startGame = new Game(carList, roundNum);

        Game endGame = gameService.playAllGame(startGame);
        List<String> winnerList = gameService.getWinner(endGame);

        output.printWinner(winnerList);
    }


    private List<Car> createCarList() {
        List<String> carNames = input.inputCarNames();
        return convertCarName(carNames);
    }

    private List<Car> convertCarName(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}
