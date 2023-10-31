package racingcar.service;

import static racingcar.Constants.MOVEMENT;
import static racingcar.Constants.MOVEMENT_CONDITION;
import static racingcar.Constants.NUMBER_END;
import static racingcar.Constants.NUMBER_START;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarRecord;
import racingcar.repository.CarRepository;

public class CarService {
    private final CarRepository carRepository = new CarRepository();

    public CarService() {
    }

    public void carMovement(Car car) {
        if (MOVEMENT_CONDITION <= Randoms.pickNumberInRange(NUMBER_START, NUMBER_END)) {
            setCarStatus(car);
        }
    }

    public void setCarStatus(Car car) {
        CarRecord newCar = CarRecord.of(car.getId(), car.getName(), car.getPosition() + MOVEMENT);
        this.carRepository.save(newCar);
    }

}
