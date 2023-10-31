package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.mapper.AttemptMapper;
import racingcar.controller.mapper.CarNameMapper;
import racingcar.model.Car;
import racingcar.model.vo.Attempt;
import racingcar.model.vo.CarName;
import racingcar.validation.AttemptValidator;
import racingcar.validation.NameValidator;

public class RacingGameController {

    private CarNameMapper carNameMapper;
    private NameValidator nameValidator;
    private AttemptValidator attemptValidator;
    private AttemptMapper attemptMapper;

    public RacingGameController() {
        this.carNameMapper = new CarNameMapper();
        this.nameValidator = new NameValidator();
        this.attemptValidator = new AttemptValidator();
        this.attemptMapper = new AttemptMapper();
    }

    public List<Car> makeCar(String carNames) {
        // validate has comma
        nameValidator.validate(carNames);
        // convert String to CarName
        List<CarName> carNameGroup = carNameMapper.toCarName(carNames);
        // validate & make Car
        List<Car> carGroup = new ArrayList<>();
        for (CarName name : carNameGroup) {
            nameValidator.validate(name);
            Car car = Car.make(name);
            carGroup.add(car);
        }
        return carGroup;
    }

    public Attempt setAttempts(String attemptStr) {
        // validate
        attemptValidator.validate(attemptStr);
        // convert String to Attempt
        Attempt attempt = attemptMapper.toAttempt(attemptStr);
        // save attempts
        return attempt;
    }

    public String startGame(List<Car> cars) {
        String result = "";
        for (Car car : cars) {
           car.playGameOneRound();
           result += car.toString();
        }
        return result;
    }
}
