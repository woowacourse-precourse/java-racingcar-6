package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputCarName {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> createCar() {
        List<String> carList;
        String[] carName = Console.readLine().split(",");
        carList = Arrays.stream(carName).map(String::trim).collect(Collectors.toList());
        carList.forEach(name -> cars.add(new Car(name)));
        return cars;
    }
}