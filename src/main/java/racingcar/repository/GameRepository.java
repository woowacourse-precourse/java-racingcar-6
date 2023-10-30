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

    public void addCars(String[] carArr) {
        cars.init(carArr);
    }

    public void initGameNum(int num) {
        gameNum.init(num);
    }

    public int findGameNum() {
        return gameNum.find();
    }
}
