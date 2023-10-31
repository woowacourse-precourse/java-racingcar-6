package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.ResultRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    public static final int MAX_BIGGER_NUMBER = 4;
    public static final int PICK_MIN_NUMBER = 0;
    public static final int PICK_MAX_NUMBER = 9;
    private CarRepository carRepository;
    private ResultRepository resultRepository;

    public RacingService(CarRepository carRepository, ResultRepository resultRepository) {
        this.carRepository = carRepository;
        this.resultRepository = resultRepository;
    }
    public void initializeGame(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.add(new Car(carName));
        }
    }

    public List<Car> progressRacing() {
        for (Car car : carRepository.getCarList()) {
            if (isBiggerThanFour(getRandomValue())) {
                car.increaseDistance();
            }
        }
        return carRepository.getCarList();
    }

    public List<Car> chooseWinner() {
        List<Integer> distanceList = carRepository.getCarList().stream().map(Car::getDistance).collect(Collectors.toList());
        int maxDistance = Collections.max(distanceList);

        for (Car car : carRepository.getCarList()) {
            selectWinner(maxDistance, car);
        }
        return resultRepository.getResultList();
    }

    private void selectWinner(int maxDistance, Car car) {
        if (car.getDistance() == maxDistance) {
            resultRepository.add(car);
        }
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(PICK_MIN_NUMBER, PICK_MAX_NUMBER);
    }
    
    private boolean isBiggerThanFour(int number) {
        return number >= MAX_BIGGER_NUMBER;
    }
}
