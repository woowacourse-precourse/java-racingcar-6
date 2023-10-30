package racingcar.validator.model;

import java.util.HashMap;
import java.util.Map;
import racingcar.exception.ValidatorNotFoundException;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.TotalNumberOfRounds;

public class ModelValidator {
    private static final Map<Class, ModelValidator> validatorMap = new HashMap<>() {{
        put(CarName.class, new CarNameValidator());
        put(Cars.class, new CarsValidator());
        put(Car.class, new CarValidator());
        put(TotalNumberOfRounds.class, new TotalNumberOfRoundsValidator());
    }};

    public void validate(Object target) {
        ModelValidator validator = validatorMap.get(target.getClass());
        if (validator == null) {
            throw new ValidatorNotFoundException();
        }
        validator.validate(target);
    }
}
