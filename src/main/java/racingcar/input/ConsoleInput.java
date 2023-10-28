package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.Car;

public class ConsoleInput implements Input {

    @Override
    public List<Car> receiveCarNamesAndMakeList() {
        String input = validateInputCarName(Console.readLine());
        return getCarList(input);
    }

    @Override
    public int receiveTotalCountOfExecution() {
        String input = validateInputCount(Console.readLine());
        return Integer.parseInt(input);
    }

    private String validateInputCarName(String input) {
        checkForm(input);
        checkDuplication(input);
        return input;
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
                .toList();

        if (list.size() != distinctList.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> getCarList(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .toList();
    }

    private String validateInputCount(String input) {
        //1 ~ 100사이의 숫자만 허용
        if (!Pattern.matches("^([1-9]|[1-9][0-9]|100)$", input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
