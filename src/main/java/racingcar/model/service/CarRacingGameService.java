package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.repository.CarRepository;
import racingcar.util.InputValueValidator;

public class CarRacingGameService {

    private final CarRepository carRepository;
    private final InputValueValidator inputValueValidator;

    public CarRacingGameService() {
        this.carRepository = new CarRepository();
        this.inputValueValidator = new InputValueValidator();
    }

    public void generateCar(String inputCarNames) {
        List<String> cars = inputValueValidator.validateName(inputCarNames);

        for (int i = 0; i < cars.size(); i++) {
            String carName = cars.get(i);
            Car car = new Car(carName, 0); // 초기 위치는 0으로 설정
            carRepository.save(car);
        }
    }

}
