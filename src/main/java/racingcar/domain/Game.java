package racingcar.domain;

import racingcar.common.RandomNumberGenerator;
import racingcar.domain.dto.CarDtos;

public class Game {
    private final Cars cars;
    private final GameCount totalRounds;
    private final GameCount currentRound;

    public Game(final String carNames, final String totalRounds, final RandomNumberGenerator randomNumberGenerator) {
        this.cars = new Cars(carNames,randomNumberGenerator);
        this.totalRounds = new GameCount(totalRounds);
        this.currentRound = new GameCount("0");
    }

    public void playRound() {
        moveAll();
        currentRound.increase();
    }


    public void moveAll() {
        cars.forEach(Car::move);
    }

    public boolean isFinished() {
        return currentRound.equals(totalRounds);
    }

    public CarDtos createCarDtos(){
        return this.cars.toCarDtos();
    }
}
