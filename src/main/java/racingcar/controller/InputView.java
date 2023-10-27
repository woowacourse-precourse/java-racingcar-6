package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Attempt;
import racingcar.domain.Car;

import java.util.List;

public class InputView {

    private static final String ERR_NOT_NUMBER = "입력값이 숫자가 아닙니다.";

    public List<Car> getCars() {
        String line = Console.readLine();
        List<String> names = splitNames(line);
        return buildCars(names);
    }

    private static List<Car> buildCars(List<String> names) {
        return names.stream().map(Car::new).toList();
    }

    private static List<String> splitNames(String line) {
        return List.of(line.split(""));
    }

    public Attempt getAttempt() {
        String line = Console.readLine();
        validateNumber(line);
        return new Attempt(Integer.parseInt(line));
    }

    private static void validateNumber(String line) {
        for(char c : line.toCharArray()) {
            if(!Character.isDigit(c))throw new IllegalArgumentException(ERR_NOT_NUMBER);
        }
    }

}
