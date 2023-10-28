package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CarGroups {
    List<Car> racingCars;

    public CarGroups(List<String> carNames) {
        validateCarSize(carNames);
        validateNameLength(carNames);
        this.racingCars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateCarSize(List<String> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 없습니다.");
        }
    }

    private void validateNameLength(List<String> racingCars) {
        boolean result = racingCars.stream()
                .mapToInt(String::length)
                .anyMatch(length -> length > 5);
        if (result) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void go() {
        for (Car car : racingCars) {
            int rand = Randoms.pickNumberInRange(0, 9);
            if (rand >= 4) {
                car.go(rand);
            }
        }
    }

    public String getWinners() {
        long maxPosition = racingCars.stream()
                .mapToLong(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대값이 없습니다."));

        List<String> winnerNames = racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        return String.join(", ", winnerNames);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCars) {
            sb.append(car.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
