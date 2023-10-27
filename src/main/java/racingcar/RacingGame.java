package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public RacingGame() {
    }

    public List<Car> inputCarNames(String input) {
        List<String> names = Arrays.stream(splitNames(input))
                .map(this::removeWhiteSpace)
                .toList();

        checkHasDuplicates(names);

        return names.stream()
                .map(name -> new Car(new Name(name), new Position()))
                .toList();
    }

    private String[] splitNames(String names) {
        return names.split(Constants.COMMA);
    }

    private String removeWhiteSpace(String name) {
        return name.replace(Constants.WHITESPACE, Constants.EMPTY);
    }

    private void checkHasDuplicates(List<String> names) {
        int uniqueSize = names.stream()
                .distinct().toList().size();

        if (names.size() != uniqueSize) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public int inputAttemptCount(String input) {
        checkAttemptCountIsInteger(input);
        return toInt(input);
    }

    private void checkAttemptCountIsInteger(String input) {
        if (!Constants.INTEGER.matcher(input).matches()) {
            throw new IllegalArgumentException("정수를 입력해야합니다.");
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public String printCarName(List<Car> cars) {
        StringBuilder result = new StringBuilder();

        for (Car car : cars) {
            result.append(Constants.WHITESPACE).append(car.getNameValue()).append(Constants.COMMA);
        }

        trim(result);

        return result.toString();
    }

    private void trim(StringBuilder result) {
        result.deleteCharAt(0);
        result.deleteCharAt(result.length() - 1);
    }
}
