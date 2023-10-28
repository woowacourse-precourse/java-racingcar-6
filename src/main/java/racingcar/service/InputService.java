package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class InputService {
    OutputView outputView = new OutputView();

    public List<Car> inputCarName() {
        outputView.inputCarName();
        String[] inputNames = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : inputNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public int inputTimes() {
        outputView.howManyTime();
        int times = Integer.parseInt(Console.readLine());
        return times;
    }
}
