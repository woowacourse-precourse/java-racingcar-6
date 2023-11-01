package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.respository.RacingRepository;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final RacingRepository racingRepository;
    private final Validation validation;

    public RacingService(RacingRepository racingRepository, Validation validation) {
        this.racingRepository = racingRepository;
        this.validation = validation;
    }

    public void saveCars(String carsName) {
        String[] cars = carsName.split(",");
        for (String car : cars) {
            car = car.trim();
            validation.validateCarName(car);
            racingRepository.saveCar(new Car(car));
        }
    }

    public void saveAttempts(String attempt) {
        validation.validateAttempts(attempt);
        racingRepository.saveAttempts(Integer.parseInt(attempt));
    }

    public List<Car> findCars() {
        return racingRepository.findCars();
    }

    public Integer findAttempt() {
        return racingRepository.findAttempts();
    }

    public List<Car> move() {
        List<Car> cars = racingRepository.findCars();
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
        return cars;
    }

    public List<Car> findWinner() {
        List<Car> cars = racingRepository.findCars();
        List<Car> winners = new ArrayList<>();
        int moveMost = 0;
        for (Car car : cars) {
            int move = car.getMoves();
            if (move > moveMost) {
                moveMost = move;
                winners.clear();
                winners.add(car);
            } else if (move == moveMost) {
                winners.add(car);
            }
        }
        return winners;
    }
}
