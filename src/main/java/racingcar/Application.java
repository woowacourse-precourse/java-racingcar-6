package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Car> generateCarList() {
        String[] carNames;
        List<Car> carList = new ArrayList<>();

        carNames = inputNames();
        addCars(carList, carNames);
        return carList;
    }

    private static String[] inputNames() {
        String input = Console.readLine();
        String[] result = input.split(",");

        return result;
    }

    private static void addCars(List<Car> carList, String[] carNames) {
        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }
}
