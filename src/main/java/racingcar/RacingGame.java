package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.round.Round;

public class RacingGame {

    private static RacingGame game = new RacingGame();
    private GameView gameView = GameView.getInstance();
    private List<Car> cars;
    private Round round;

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return game;
    }

    public void startGame() {
        makeCarList();
        getRound();
        raceStart(this.round);
        findWinners();
    }

    private void makeCarList() {
        cars = new ArrayList<>();
        String[] carNames = gameView.carsInput();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void getRound() {
        String roundString = gameView.roundInput();
        round = new Round(roundString);
    }

    private void raceStart(Round round) {
        gameView.printRound();
        while (this.round.getRound() > 0) {
            moveCars();
            gameView.printRound(cars);
            this.round.decreaseRound();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomValue = car.getRandomValue();
            car.forward(randomValue);
        }
    }

    private void findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = findMaxPosition(cars);
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        gameView.printWinners(winners);
    }


    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
