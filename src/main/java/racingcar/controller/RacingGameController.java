package racingcar.controller;

import java.util.List;
import racingcar.controller.mapper.AttemptMapper;
import racingcar.controller.mapper.CarNameMapper;
import racingcar.model.Car;
import racingcar.model.repository.InMemoryRepository;
import racingcar.model.vo.Attempt;
import racingcar.model.vo.CarName;
import racingcar.validation.AttemptValidator;
import racingcar.validation.NameValidator;

public class RacingGameController {

    private CarNameMapper carNameMapper;
    private NameValidator nameValidator;
    private InMemoryRepository inMemoryRepository;
    private AttemptValidator attemptValidator;
    private AttemptMapper attemptMapper;

    public RacingGameController() {
        this.carNameMapper = new CarNameMapper();
        this.nameValidator = new NameValidator();
        this.inMemoryRepository = new InMemoryRepository();
        this.attemptValidator = new AttemptValidator();
        this.attemptMapper = new AttemptMapper();
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
            inMemoryRepository.save(name, car);
        }
    }

    public void setAttempts(String attemptStr) {
        // validate
        attemptValidator.validate(attemptStr);
        // convert String to Attempt
        Attempt attempt = attemptMapper.toAttempt(attemptStr);
        // save attempts
    }

    public void startGame() {

    }
}
