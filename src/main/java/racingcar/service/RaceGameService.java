package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RaceGameService {
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator;

    public RaceGameService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void initializeCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void startRace(int maxRound, OutputView outputView) {
        for (int round = 0; round < maxRound; round++) {
            race();
            outputView.printRaceResult(cars);
        }
    }
    public void race() {
        for (Car car : cars) {
            car.moveForwardCar(randomNumberGenerator.generateUniqueNumbers());
        }
    }
    public String getWinners(Referee referee) {
        return referee.determineWinners(cars);
    }

}
