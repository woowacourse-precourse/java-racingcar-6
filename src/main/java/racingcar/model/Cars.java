package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(){
        this.cars = userInputToCars(userInputToStringList());
    }

    private List<String> userInputToStringList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<Car> userInputToCars(List<String> userInput) {
        List<Car> carList = new ArrayList<>();
        for (String name : userInput) {
            CarName carName = new CarName(name);
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public List<Car> getCars() {
        return cars;
    }


}
