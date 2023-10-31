package racingcar.domain;

import racingcar.common.RandomNumberGenerator;
import racingcar.domain.dto.CarDtos;
import racingcar.domain.dto.WinnersDto;

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
        this.currentRound.increase();
    }

    public CarDtos createCarDtos(){
        return this.cars.toCarDtos();
    }

    public WinnersDto createWinnersDto(){
        return this.cars.toWinnersDto();
    }

    public void moveAll() {
        this.cars.forEach(Car::move);
    }

    public boolean isFinished() {
        return this.currentRound.equals(this.totalRounds);
    }

}
