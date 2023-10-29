package racingcar;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int makePlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = readLine();
        int playCount = Integer.parseInt(inputCount);

        return playCount;
    }

    public static void findCarListError(String[] carList) {
        Set<String> uniqueCar = new HashSet<>();
        for (int i = 0; i < carList.length; i++) {
            if (carList[i].length() > 5 || carList[i] == "" || !uniqueCar.add(carList[i])) {
                throw new IllegalArgumentException();
            }
        }
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
        int playCount = makePlayCount();
    }
}
