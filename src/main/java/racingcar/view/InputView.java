package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Attempt;
import racingcar.domain.Car;

import java.util.List;

public class InputView {

    private static final String ERR_NOT_NUMBER = "입력값이 숫자가 아닙니다.";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";

    public List<Car> getCars() {
        String line = Console.readLine();
        List<String> names = splitNames(line);
        return buildCars(names);
    }

    private static List<Car> buildCars(List<String> names) {
        return names.stream().map(Car::new).toList();
    }

    private static List<String> splitNames(String line) {
        return List.of(line.split(","));
    }

    public Attempt getAttempt() {
        String line = Console.readLine();
        validateNumber(line);
        return new Attempt(Integer.parseInt(line));
    }

    private static void validateNumber(String line) {
        if(!line.matches(ONLY_NUMBER_REGEX)) throw new IllegalArgumentException(ERR_NOT_NUMBER);
    }

}
