package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private List<Car> transformStringToCarList(String cars){
        List<Car> carList = new ArrayList<>();
        for (String carName : Arrays.stream(cars.split(",")).toList()) {
            final Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        Console.readLine();
    }
}
