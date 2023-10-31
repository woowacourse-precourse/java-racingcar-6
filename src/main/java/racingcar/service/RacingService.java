package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.dto.request.CarNamesDto;
import racingcar.dto.response.WinnersDto;

public class RacingService {

    private static final int MOVEMENT_CONDITION = 4;

    private final CarRepository carRepository;

    public RacingService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(final CarNamesDto carNames) {
        for(String name: carNames.getNames()) {
            carRepository.save(name);
        }
    }

    public void action() {
        List<Car> carList = carRepository.findAll();
        int condition;
        for(Car car: carList) {
            condition = Randoms.pickNumberInRange(0, 9);
            if(condition >= MOVEMENT_CONDITION) {
                car.updateForwardCount();
                carRepository.update(car);
            }
        }
    }

    public WinnersDto findWinners() {
        List<Car> carList = carRepository.findAll();
        Integer maximumScore = findMaximumScore(carList);

        List<Car> winners = new ArrayList<>();
        for (Car car: carList) {
            if (car.getForwardCount() == maximumScore) {
                winners.add(car);
            }
        }

        return new WinnersDto(winners);
    }

    private Integer findMaximumScore(List<Car> carList) {
        Integer max = 0;
        for(Car car: carList) {
            if(max < car.getForwardCount()) {
                max = car.getForwardCount();
            }
        }
        return max;
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
