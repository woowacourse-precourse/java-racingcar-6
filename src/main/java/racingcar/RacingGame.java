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
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATEDNAME.message());
        }
    }

    public String printCarName(List<Car> cars) {
        StringBuilder result = new StringBuilder();

        cars.stream().map(Car::getNameValue)
                .forEach((name)->addResult(result,name));


        trim(result);

        return result.toString();
    }

    private void addResult(StringBuilder result,String name){
        result.append(Constants.WHITESPACE).append(name).append(Constants.COMMA);
    }

    private void trim(StringBuilder result) {
        result.deleteCharAt(0);
        result.deleteCharAt(result.length() - 1);
    }
}
