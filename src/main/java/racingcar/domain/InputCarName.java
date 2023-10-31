package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputCarName {
    private final List<Car> cars = new ArrayList<>();

    public void createCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carList;
        String[] carName = Console.readLine().split(",");
        carList = Arrays.stream(carName).map(String::trim).collect(Collectors.toList());
        carList.forEach(name -> cars.add(new Car(name)));
        System.out.println(carList);
    }
}