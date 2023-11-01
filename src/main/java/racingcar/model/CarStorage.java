package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarStorage {

    private final List<Car> storage;

    public CarStorage(List<Car> storage) {
        validateCarName(storage);
        validateDuplicateName(storage);
        this.storage = storage;
    }

    public void updateCarDistance(List<Integer> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) >= 4) {
                storage.get(i).updateDistance();
            }
        }
    }

    public List<Car> getNameAndDistance() {
        /**
         * storage에 저장된 Car 객체의 이름과 거리를 복사한 새로운 객체를 반환
         * (원본 Car 객체의 메모리 값을 전달하지 않음)
         */
        return storage.stream()
                .map(car -> new Car(car.getName(), car.getDistance()))
                .toList();
    }

    private void validateCarName(List<Car> storage) {
        List<String> carNames = storage.stream()
                .map(Car::getName)
                .toList();

        for (String name : carNames) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicateName(List<Car> storage) {
        Set<Car> carSet = new HashSet<>(storage);
        if (carSet.size() != storage.size()) {
            throw new IllegalArgumentException();
        }
    }
}
