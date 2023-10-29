package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static List<String> inputCarNameList() {
        String[] stringArray = Console.readLine().split(",");
        return List.of(stringArray);
    }

    public static List<Car> getCarsFromInput() {
        List<String> carNameList = inputCarNameList();
        boolean isLengthExceed = carNameList.stream().anyMatch(carName -> carName.length() > 5);
        if (isLengthExceed) {
            throw new IllegalArgumentException();
        }
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Car> cars = getCarsFromInput();
    }
}
