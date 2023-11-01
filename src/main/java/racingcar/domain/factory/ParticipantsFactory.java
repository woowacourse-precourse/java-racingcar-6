package racingcar.domain.factory;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Participants;

public class ParticipantsFactory {
    private final CarFactory carFactory;

    public ParticipantsFactory(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public Participants createFromNames(List<String> names) {
        List<Car> cars = mapToCars(names);

        return new Participants(cars);
    }

    private List<Car> mapToCars(List<String> names) {
        return names.stream()
                .map(carFactory::create)
                .toList();
    }
}
