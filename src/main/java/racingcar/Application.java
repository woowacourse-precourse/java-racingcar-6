package racingcar;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void findCarListError(String[] carList) {
        Set<String> uniqueCar = new HashSet<>();
    }

    public static String[] makeCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = readLine();
        if (inputCar == "" || inputCar.contains(" ")) {
            throw new IllegalArgumentException();
        }

        String[] carList = inputCar.split(",");
        findCarListError(carList);

        return carList;
    }

    public static void main(String[] args) {
        String[] carList = makeCarList();
    }
}
