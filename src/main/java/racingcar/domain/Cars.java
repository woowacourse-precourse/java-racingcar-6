package racingcar.domain;

import java.util.List;
import java.util.function.BiFunction;

public class Cars {
    private static final String DUPLICATE_ERROR_MESSAGE = "이미 존재하는 자동차 이름입니다.";
    private static final String INIT_VALUE = "";
    private static final String SEPARATOR = " : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String LINE_FEED = "\n";
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void add(String name) {
        validateDuplicate(name);
        carList.add(Car.getNewCar(name));
    }

    public void move(Referee referee) {
        carList.forEach(car -> {
            boolean isCanMove = referee.shouldMove();
            car.move(isCanMove);
        });
    }

    public String getStringOfRaceResult() {
        return carList.stream()
                .reduce(INIT_VALUE, getParsedResultBiFunction(), String::join);
    }

    public List<String> getWinnerNameList() {
        int winnerPosition = getMaxPosition();

        return getCarNameListByPosition(winnerPosition);
    }

    private void validateDuplicate(String newName) {
        carList.stream()
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

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private List<String> getCarNameListByPosition(int position) {
        return carList.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .toList();
    }
}
