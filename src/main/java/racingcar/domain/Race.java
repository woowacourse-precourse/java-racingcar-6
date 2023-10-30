package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 양수 여야만 합니다.");
        }

        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여하는 자동차는 한 대 이상 이여 야만 합니다");
        }

        this.cars = cars;
        this.rounds = rounds;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRounds() {
        return rounds;
    }
}
