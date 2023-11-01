package racingcar.domain;

import java.util.List;

public class Cars {
    public static final String LINE_BREAK = "\n";
    private List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map((name) -> new Car(name.trim()))
                .distinct()
                .toList();

        validateNameDuplication(names);
    }

    private void validateNameDuplication(List<String> names) {
        if (isDuplicatedNameExist(names)) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    private boolean isDuplicatedNameExist(List<String> names) {
        return names.size() != cars.size();
    }

    public void tryToMove(MovingStrategy movingStrategy) {
        cars.stream()
                .forEach((car) -> car.tryToMove(movingStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        cars.stream()
                .forEach((car) -> result.append(car.toString()).append(LINE_BREAK));

        return result.toString().trim();
    }
}
