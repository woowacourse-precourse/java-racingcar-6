package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarsManage {
    List<Car> cars = new ArrayList<>();
    public void inputCars() {
        String carInput = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(carInput, ",");

        while (stringTokenizer.hasMoreTokens()) {
            Car car = new Car();
            car.setName(stringTokenizer.nextToken());
            cars.add(car);
        }
    }
}
