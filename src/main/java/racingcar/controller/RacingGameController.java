package racingcar.controller;

import java.util.List;
import racingcar.controller.mapper.CarNameMapper;
import racingcar.model.Car;
import racingcar.model.repository.CarRepository;
import racingcar.model.vo.CarName;
import racingcar.validation.NameValidator;

public class RacingGameController {

    private CarNameMapper carNameMapper;
    private NameValidator nameValidator;
    private CarRepository carRepository;

    public RacingGameController() {
        this.carNameMapper = new CarNameMapper();
        this.nameValidator = new NameValidator();
        this.carRepository = new CarRepository();
    }

    public void setCarName(String carNames) {
        // validate has comma
        nameValidator.validate(carNames);
        // convert String to CarName
        List<CarName> carNameGroup = carNameMapper.toCarName(carNames);
        // validate & make Car & save
        for (CarName name : carNameGroup) {
            nameValidator.validate(name);
            Car car = Car.make(name);
            carRepository.save(name, car);
        }
    }

    public void setAttempts(String attempts) {
        // validation
        // save attempts
    }

    public void startGame() {

    }
}
