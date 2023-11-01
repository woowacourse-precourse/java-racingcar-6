package racingcar.gameplayer;

import racingcar.carfactory.Car;
import racingcar.carfactory.CarFactory;
import racingcar.service.GameService;
import racingcar.service.IoService;

import java.awt.font.GlyphMetrics;
import java.util.List;

public class GamePlayer {
    private CarFactory carFactory;
    private GameService gameService;
    private IoService ioService;
    public GamePlayer(){
        this.carFactory = new CarFactory();
        this.gameService = new GameService();
        this.ioService = new IoService();
    }

    public GamePlayer(CarFactory carFactory,GameService gameService,IoService ioService){
        this.carFactory = carFactory;
        this.gameService = gameService;
        this.ioService = ioService;
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
