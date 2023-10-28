package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CarGroups {
    List<Car> racingCars;

    public CarGroups(List<Car> racingCars) {
        validateCarSize(racingCars);
        validateNameLength(racingCars);
        this.racingCars = racingCars;
    }

    private void validateCarSize(List<Car> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 없습니다.");
        }
    }

    private void validateNameLength(List<Car> racingCars) {
        boolean result = racingCars.stream()
                .mapToLong(car -> car.getName().length())
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
}
