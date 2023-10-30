package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

final class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final Roulette roulette;
    private int maxDistance = 0;

    Cars(Roulette roulette, String inputNames) {
        this.roulette = roulette;

        String[] names = inputNames.split(Constant.COMMA.value, -1);
        validateNames(names);

        cars.addAll(Arrays.stream(names)
                .map(Car::new)
                .toList());
    }

    void tryMove() {
        cars.forEach(car -> {
            if(roulette.spin() >= Rule.GO.value) maxDistance = Math.max(maxDistance, car.move());
        });
    }

    List<String> collectCurrentStatus() {
        return cars.stream()
                .map(Car::currentStatus)
                .collect(Collectors.toList());
    }

    List<String> whosWinners() {
        return cars.stream()
                .filter(car -> car.isFront(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateNames(String[] names) {
        var uniqueNameCount = Arrays.stream(names).distinct().count();
        if (names.length < 1 || names.length != uniqueNameCount) throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars target = (Cars) o;
        if (Objects.equals(cars, target.cars)) return true;
        if (cars.size() != target.cars.size()) return false;
        for (int i = 0; i < cars.size(); i++) {
            if(!cars.get(i).equals(target.cars.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, roulette);
    }
}
