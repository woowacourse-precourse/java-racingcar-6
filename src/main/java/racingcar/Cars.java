package racingcar;

import static racingcar.CarNameParser.splitAndStrip;

import java.util.List;

public class Cars {

    private static final int MIN_QUANTITY = 2;
    private List<Car> cars;

    public Cars(String input) {
        List<String> nameOfCars = splitAndStrip(input);

        checkDuplicated(nameOfCars);

        cars = nameOfCars.stream()
                .map(carName -> new Car(new CarName(carName)))
                .toList();

        checkSize();
    }

    private void checkDuplicated(List<String> nameOfCars) {
        long sizeAfterDistinct = nameOfCars.stream().distinct().count();
        if (sizeAfterDistinct != nameOfCars.size()) {
            throw new IllegalArgumentException("중복된 이름입니다.");
        }
    }

    private void checkSize() {
        if (cars.size() < MIN_QUANTITY) {
            throw new IllegalArgumentException("자동차는 최소 " + MIN_QUANTITY + "개 이상이어야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
