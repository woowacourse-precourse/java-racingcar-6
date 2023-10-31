package racingcar.gameplayer;

import racingcar.carfactory.Car;
import racingcar.carfactory.CarFactory;
import racingcar.service.GameService;
import racingcar.service.IoService;

import java.util.List;

public class GamePlayer {
    CarFactory carFactory;
    GameService gameService;
    IoService ioService;

    public GamePlayer() {
        carFactory = new CarFactory();
        gameService = new GameService();
        ioService = new IoService();
    }

    public void randomAdvanceAll(List<Car> cars) {
        cars.stream().forEach((car) -> {
            car.advanceOnceRandomly(gameService);
        });
    }

    public void oneTurn(List<Car> cars) {
        randomAdvanceAll(cars);
        ioService.printOneTurnResult(cars);
    }

    public void playGame(int totalRound, List<Car> cars) {
        System.out.println("실행 결과");
        for (int round = 0; round < totalRound; round++) {
            oneTurn(cars);
        }
    }

    public void startGame() {
        List<String> carNames = ioService.inputCarNames();
        List<Car> cars = carFactory.createCars(carNames);

        int totalRound = ioService.inputTurnNumber();

        playGame(totalRound, cars);

        List<Car> winners = gameService.selectWinner(cars);
        ioService.printWinner(winners);
    }
}
