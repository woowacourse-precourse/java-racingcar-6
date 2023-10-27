package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class InputView {

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

}
