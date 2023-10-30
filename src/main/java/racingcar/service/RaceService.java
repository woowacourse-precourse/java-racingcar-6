package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.repository.RaceRepository;
import racingcar.util.Parser;
import racingcar.util.Validator;

public class RaceService {
    private static final int CAR_DISTANCE_MIN_MOVE_CONDITION = 4;
    private static final int CAR_DISTANCE_MIN_RANDOM_NUMBER = 0;
    private static final int CAR_DISTANCE_MAX_RANDOM_NUMBER = 9;

    private final RaceRepository raceRepository = new RaceRepository();
    private final Validator validator = new Validator();
    private final Parser parser = new Parser();

    public void playARace(Race race) {
        moveCarsByRandom(race.getCars());
        race.increaseGameOrder();
    }

    public Race createRace(List<Car> cars, int numRaces) {
        return new Race(cars, numRaces);
    }

    public Long saveRace(Race race) {
        return raceRepository.save(race);
    }

    public List<String> getWinners(Race race) {
        List<Car> cars = race.getCars();
        List<Integer> carPositions = getCarPositions(cars);
        int maxPosition = findMaxPosition(carPositions);
        return getCarNamesOfMaxPosition(maxPosition, cars);
    }

    public List<String> processCarNames(String carNames) {
        validator.validateCarNamesInput(carNames);
        return parser.parseCarNames(carNames);
    }

    public int processNumRaces(String numRacesInput) {
        validator.validateNumRacesInput(numRacesInput);
        return parser.parseNumGames(numRacesInput);
    }

    private List<Car> moveCarsByRandom(List<Car> cars) {
        for (Car car : cars) {
            moveCarByRandom(car);
        }
        return cars;
    }

    private void moveCarByRandom(Car car) {
        int distance = generateRandomNumber();
        if (distance >= CAR_DISTANCE_MIN_MOVE_CONDITION) {
            car.move(distance);
        }
    }

    private int findMaxPosition(List<Integer> position) {
        return Collections.max(position);
    }

    private List<Integer> getCarPositions(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    private List<String> getCarNamesOfMaxPosition(int maxPosition, List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(CAR_DISTANCE_MIN_RANDOM_NUMBER,CAR_DISTANCE_MAX_RANDOM_NUMBER);
    }
}
