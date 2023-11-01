package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;

public class InputView {
    public static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분, 5자 이하)");
        String input = readLine();
        String[] carNames = input.split(",");
    }

    public static List<Car> responseCarNames(String[] carNames) {
        List<String> trimmedCarNames = doTrim(carNames);

        List<Car> cars = putCars(trimmedCarNames);

        return cars;
    }

    public static List<Car> putCars(List<String> trimmedCarNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : trimmedCarNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static List<String> doTrim(String[] carNames) {
        List<String> trimmedCarNames = new ArrayList<>();
        for (String carName : carNames) {
            trimmedCarNames.add(carName.trim());
        }
        return trimmedCarNames;
    }
}
