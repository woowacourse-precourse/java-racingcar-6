package racingcar.model;

import racingcar.constant.message.Message;
import racingcar.dto.Result;
import racingcar.model.car.Car;
import racingcar.model.car.OrderByPosition;
import racingcar.model.car.OrderStrategy;
import racingcar.service.Accelerator;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

import java.util.Arrays;
import java.util.List;

public class Racer {

    private final List<Car> racer;
    private final OrderStrategy orderStrategy;

    private Racer(String value, OrderStrategy orderStrategy) {
        validate(value);
        this.racer = Arrays.stream(value.split(Message.NAME_SEPARATOR))
                .map(String::trim)
                .map(Car::ofStartingPoint)
                .toList();
        this.orderStrategy = orderStrategy;
    }

    public static Racer of(String value) {
        return new Racer(value, new OrderByPosition());
    }

    public void play(Accelerator accelerator) {
        racer.forEach(car -> car.move(accelerator));
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    //TODO: Car가 아니라 position으로 비교
    public Result getWinner() {
        Car first = racer.stream()
                .max(orderStrategy)
                .orElseThrow();
        return Result.of(racer.stream()
                .filter(car -> car.equals(first))
                .toList());
    }

    public Result getResult() {
        return Result.of(racer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Racer target)) {
            return false;
        }
        return racer.equals(target.racer);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : racer) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
