package racingcar.service;

import static racingcar.constant.Constants.IDENTITY_NUMBER;
import static racingcar.constant.Constants.MOVEMENT;
import static racingcar.constant.Constants.MOVEMENT_CONDITION;
import static racingcar.constant.Constants.NUMBER_END;
import static racingcar.constant.Constants.NUMBER_START;
import static racingcar.constant.Constants.STARTING_POSITION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRecord;
import racingcar.repository.CarRepository;

public class CarService {
    private final CarRepository carRepository = new CarRepository();

    public CarService() {
    }

    public void carGenerate(String name) {
        this.carRepository.add(new Car(
                IDENTITY_NUMBER++,
                name,
                STARTING_POSITION
        ));
    }

    public List<Car> getAllCar() {
        return this.carRepository.findAll();
    }

    public void carMovement(Car car) {
        if (MOVEMENT_CONDITION <= Randoms.pickNumberInRange(NUMBER_START, NUMBER_END)) {
            setCarStatus(car);
        }
    }

    public List<Car> carOneRound() {
        for (Car car : getAllCar()) {
            carMovement(car);
        }
        return getAllCar();
    }

    public void setCarStatus(Car car) {
        CarRecord newCar = CarRecord.of(car.getId(), car.getName(), car.getPosition() + MOVEMENT);
        this.carRepository.save(newCar);
    }

}
