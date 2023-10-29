package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.dto.request.CarNamesDto;

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

}
