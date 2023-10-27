package racingcar.input;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.Car;

public class ConsoleInput implements Input {

    @Override
    public List<Car> receiveCarNamesAndMakeList() {
        String input = Console.readLine();
        validateInputCarName(input);

        return getCarList(input);
    }

    private void validateInputCarName(String input) {
        checkForm(input);
        checkDuplication(input);
    }

    private void checkForm(String input) {
        //자동차의 이름은 5자 이하만 허용
        //자동차의 이름은 영어만 하용
        //자동차의 수는 최소 1대, 최대 10대까지 허용
        if (!Pattern.matches("^(\\w{1,5})(,\\w{1,5}){0,9}$", input)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication(String input) {
        List<String> list = Arrays.asList(input.split(","));
        List<String> distinctList = list.stream()
                .distinct()
                .collect(toList());

        if (list.size() != distinctList.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> getCarList(String input) {
        return Arrays.asList(input.split(","))
                .stream()
                .map(carName -> new Car(carName))
                .collect(toList());
    }

    @Override
    public int receiveTotalCountOfExecution() {
        String input = Console.readLine();
        validateInputCount(input);

        return Integer.valueOf(input);
    }

    private void validateInputCount(String input) {
        //1 ~ 100사이의 숫자만 허용
        if (!Pattern.matches("^([1-9]|[1-9][0-9]|100)$", input)) {
            throw new IllegalArgumentException();
        }
    }
}
