package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Application {

    public static void findPlayCountError(String inputCount) {
        try {
            int playCount = Integer.parseInt(inputCount);
            if (playCount < 1 || playCount > 100) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int makePlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = Console.readLine();
        findPlayCountError(inputCount);

        return Integer.parseInt(inputCount);
    }

    public static void findCarListError(String[] carList) {
        if (carList.length < 2) {
            throw new IllegalArgumentException();
        }

        Set<String> uniqueCar = new HashSet<>();
        for (String s : carList) {
            if (s.length() > 5 || s.equals("") || !uniqueCar.add(s)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static String findInputCarError() {
        String inputCar = Console.readLine();
        if (Objects.equals(inputCar, "") || inputCar.contains(" ")) {
            throw new IllegalArgumentException();
        }
        if (!inputCar.contains(",") || inputCar.matches(",*")) {
            throw new IllegalArgumentException();
        }

        return inputCar;
    }

    public static String[] makeCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = findInputCarError();

        String[] carList = inputCar.split(",");
        findCarListError(carList);

        return carList;
    }

    public static void main(String[] args) {
        String[] carList = makeCarList();
        int playCount = makePlayCount();

        RacingGame.playGame(carList, playCount);
    }
}
