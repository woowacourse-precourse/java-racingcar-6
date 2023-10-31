package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constants.RacingCarConstants.FORWARD_THRESHOLD;

public class RaceService {

    private final RandomNumberService randomNumberService;

    public RaceService(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    public void executeRace(Race race) {
        int totalRounds = race.getTotalRounds();

        for (int i = 0; i < totalRounds; i++) {
            int randomNumber = randomNumberService.generateRandomNumber();
            moveCars(race.getCars(), randomNumber);
            ResultView.printRoundResult(race.getCars());
        }
    }

    private void moveCars(List<Car> cars, int randomNumber) {
        for (Car car : cars) {
            boolean isMovable = randomNumber >= FORWARD_THRESHOLD.getValue();
            if (isMovable) {
                car.move(true);
            }
        }
    }

    public List<Car> findWinners(Race race) {
        List<Car> cars = race.getCars();
        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new RuntimeException("최종 우승자를 찾는데 실패했습니다."));
    }

}
