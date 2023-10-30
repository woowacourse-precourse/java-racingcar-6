package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        startRacing();
    }

    private static void startRacing() {
        List<Car> carList = inputAndGetCarList();
    }

    private static List<Car> inputAndGetCarList() {
        String carNames = inputCarNames();
        return getCarList(carNames);
    }

    private static String inputCarNames() {
        System.out.println("\"경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<Car> getCarList(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }
}
