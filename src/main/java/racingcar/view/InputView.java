package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class InputView {
    public static List<Car> inputCarNames() {
        List<String> carNames = Arrays.stream(Console.readLine().split(",")).toList();
        List<Car> cars = new ArrayList<>();
        for (String carname : carNames) {
            Car car = new Car(carname);
            cars.add(car);
        }
        return cars;
    }
}
