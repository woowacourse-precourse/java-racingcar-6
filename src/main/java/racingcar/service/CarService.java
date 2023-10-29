package racingcar.service;

import static racingcar.constant.MessageConst.WINNER_MESSAGE;
import static racingcar.constant.NumberConst.FORMAT_NUMBER;
import static racingcar.constant.NumberConst.RANDOM_MAX_RANGE;
import static racingcar.constant.NumberConst.RANDOM_MIN_NUMBER;
import static racingcar.constant.NumberConst.RANDOM_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

    private final CarRepository carRepository = new CarRepository();

    public void save(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(carRepository::save);
    }

    public void forward() {
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            int randomNum = createRandomNum();
            updateCarScore(car, randomNum);
        }
    }

    private int createRandomNum() {
        return Randoms.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE);
    }

    public void updateCarScore(Car car, int randomNum) {
        if (randomNum >= RANDOM_MIN_NUMBER) {
            car.updateScore();
        }
    }

    public StringBuilder createRoundRaceResults() {
        StringBuilder roundRaceResults = new StringBuilder();
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            roundRaceResults.append(car.createRoundRaceResult()).append("\n");
        }
        return roundRaceResults;
    }

    public StringBuilder createWinner() {
        List<Car> cars = carRepository.getCars();
        int highestScore = findHighestScore(cars);
        List<Car> carsWithHighestScore = createCarsWithHighestScore(cars, highestScore);
        StringBuilder winner = new StringBuilder();
        winner.append(WINNER_MESSAGE).append(" : ");
        for (Car car : carsWithHighestScore) {
            winner.append(car.createWinner());
        }
        return formatOutput(winner);
    }

    public int findHighestScore(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);
    }

    public List<Car> createCarsWithHighestScore(List<Car> cars, int highestScore) {
        return cars.stream()
                .filter(car -> car.getScore() == highestScore)
                .toList();
    }

    public StringBuilder formatOutput(StringBuilder winner) {
        return winner.delete(winner.length() - FORMAT_NUMBER, winner.length());
    }
}
