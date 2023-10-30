package racingcar.repository;

import racingcar.domain.Cars;
import racingcar.domain.GameNum;

public class GameRepository {

    private final Cars cars;
    private final GameNum gameNum;

    public GameRepository() {
        this.cars = new Cars();
        this.gameNum = new GameNum();
    }

    public void initCars(String[] carArr) {
        cars.init(carArr);
    }

    public Cars getCars() {
        return cars;
    }

    public void initGameNum(int num) {
        gameNum.init(num);
    }

    public int getGameNum() {
        return gameNum.getNumber();
    }
}