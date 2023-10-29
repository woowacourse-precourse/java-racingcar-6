package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

final class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final Roulette roulette;

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
            if(roulette.spin() >= 4) car.move();
        });
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

    enum Constant {
        COMMA(","),
        ;

        String value;

        Constant(String value) {
            this.value = value;
        }
    }

}
