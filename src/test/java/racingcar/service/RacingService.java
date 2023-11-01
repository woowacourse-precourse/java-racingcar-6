package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.respository.RacingRepository;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private final RacingRepository racingRepository;
    private final List<Car> cars;

    public RacingService(RacingRepository racingRepository) {
        this.racingRepository = racingRepository;
        this.cars = racingRepository.findCars();
    }

    public void saveCar(Car car) {
        racingRepository.saveCar(car);
    }

    public void saveAttempts(Integer attempt) {
        racingRepository.saveAttempts(attempt);
    }

    public Integer findAttempt() {
        return racingRepository.findAttempts();
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public List<Car> findWinner() {
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
