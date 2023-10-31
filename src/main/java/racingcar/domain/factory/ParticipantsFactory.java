package racingcar.domain.factory;

import java.util.List;
import java.util.function.Consumer;
import racingcar.domain.Car;
import racingcar.domain.Participants;

public class ParticipantsFactory {
    private final CarFactory carFactory;
    private final Consumer<List<Car>> validator;

    public ParticipantsFactory(CarFactory carFactory, Consumer<List<Car>> validator) {
        this.carFactory = carFactory;
        this.validator = validator;
    }

    public Participants createFromNames(List<String> names) {
        List<Car> cars = mapToCars(names);

        validator.accept(cars);
        return new Participants(cars);
    }

    private List<Car> mapToCars(List<String> names) {
        return names.stream()
                .map(carFactory::create)
                .toList();
    }
}
