package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {
    String scan = Console.readLine();

    public int inputCycle() {
        int cycle = Integer.parseInt(scan);
        return cycle;
    }

    public Car makeCar(String carNames) {
        Car car = new Car(carNames);
        return car;
    }

    public List<String> splitStringCarName() {
        String carNameString = scan;
        String[] carNameStringSplit = carNameString.split(",");
        List<String> carNames = new ArrayList<String>(Arrays.asList(carNameStringSplit));
        return carNames;
    }

    public List<Car> cars(List<String> carNamesList, Car car) {
        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNamesList) {
            cars.add(makeCar(carName));
        }
        return cars;
    }
}
