package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;

public class ParticipantsFactory {
    private final CarFactory carFactory;
    private final Consumer<List<Car>> validator;

    public ParticipantsFactory(CarFactory carFactory, Consumer<List<Car>> validator) {
        this.carFactory = carFactory;
        this.validator = validator;
    }

    public Participants create(List<Car> cars) {
        validator.accept(cars);
        return new Participants(cars);
    }

    public Participants createFromName(List<String> names) {
        List<Car> cars = names.stream()
                .map(carFactory::create)
                .toList();
        return create(cars);
    }
}
