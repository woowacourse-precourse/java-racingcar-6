package racingcar.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import racingcar.domain.Car;

public class CarsValidator implements Consumer<List<Car>> {
    private static final String DUPLICATED_NAME = "경주에 참가하는 자동차 이름은 중복될 수 없습니다";
    private static final String MIN_PARTICIPANTS = "경주에 참가하는 자동차는 최소 두 대 이상이어야 합니다";
    private static final int MIN_PARTICIPANTS_SIZE = 2;

    @Override
    public void accept(List<Car> cars) {
        validateMinParticipants(cars);
        validateDuplicate(cars);
    }

    private void validateMinParticipants(List<Car> cars) {
        if (cars.size() < MIN_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException(MIN_PARTICIPANTS);
        }
    }

    private void validateDuplicate(List<Car> cars) {
        HashSet<Car> distinctCars = new HashSet<>();
        for (Car car : cars) {
            if (!distinctCars.add(car)) {
                throw new IllegalArgumentException(DUPLICATED_NAME);
            }
        }
    }
}
