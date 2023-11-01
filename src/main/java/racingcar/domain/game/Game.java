package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.enums.GameStatus;

public class Game {

    private final Cars cars;
    private final int tryNumber;
    private int currentTryNumber;
    private GameStatus gameStatus;

    public Game(int tryNumber, List<String> carNames) {
        this.cars = createCars(carNames);
        this.tryNumber = tryNumber;
        this.gameStatus = GameStatus.PLAYING;
    }

    public Cars createCars(List<String> carNames) {
        return new Cars(carNames);
    }

    public List<Car> getCarList() {
        return cars.getCars();
    }

    public boolean isPlay() {
        return gameStatus == GameStatus.PLAYING;
    }

    public void updateTryNumber() {
        currentTryNumber += 1;
        if(currentTryNumber == tryNumber) {
            gameStatus = GameStatus.END;
        }
    }


}
