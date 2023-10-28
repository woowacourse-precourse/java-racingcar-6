package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATE_ERROR_MESSAGE = "이미 존재하는 자동차 이름입니다.";
    private static final String INIT_VALUE = "";
    private static final String SEPARATOR = " : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String LINE_FEED = "\n";
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void add(String name) {
        validateDuplicate(name);
        cars.add(Car.getNewCar(name));
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public String getStringOfRaceResult() {
        return cars.stream()
                .reduce(INIT_VALUE, getParsedResultBiFunction(), String::join);
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getCarNameListByPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(String newName) {
        cars.stream()
                .map(Car::getName)
                .filter(name -> name.equals(newName))
                .findAny()
                .ifPresent(result -> {
                    throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
                });
    }

    private BiFunction<String, Car, String> getParsedResultBiFunction() {
        return (String result, Car car) ->
                new StringBuilder()
                        .append(result)
                        .append(car.getName())
                        .append(SEPARATOR)
                        .append(POSITION_SYMBOL.repeat(car.getPosition()))
                        .append(LINE_FEED)
                        .toString();
    }
}
