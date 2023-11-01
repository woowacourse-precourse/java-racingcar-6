package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private RacingService() {}

    private static class RacingServiceCreater {
        private static final RacingService INSTANCE = new RacingService();
    }

    public static RacingService getInstance() { return RacingServiceCreater.INSTANCE; }

    private final static CarRepository carRepository = CarRepository.getInstance();

    public void startRound(List<String> carNames, int tryCount) {
        createRacingCars(carNames);
    }

    public List<Car> processRound() {
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            car.moveForward(randomNum);
        }
        return cars;
    }

    public List<Car> decideWinner() {
        List<Car> cars = carRepository.getCars();
        int winningScore = getWinningScore(cars);
        List<Car> winners = cars.stream().filter(car -> car.getMoveCount() == winningScore).collect(Collectors.toList());
        return winners;
    }

    private void createRacingCars(List<String> carNames) {
        carRepository.createCars(carNames);
    }

    private int getWinningScore(List<Car> cars) {
        int winningScore = 0;
        for (Car car : cars) {
            winningScore = Math.max(winningScore,car.getMoveCount());
        }
        return winningScore;
    }
}
